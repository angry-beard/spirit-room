package fun.angrybeard.pipeline;

import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PipelineTask {

    private final PipelineMapper pipelineMapper;
    private final PipelineProcess startingProcess;
    private final Object requestParam;
    private final String serial;
    private final String name;
    private Object resultParam;
    private Integer currentProcessId;
    private Integer currentProcessOrder;
    private PipelineExecStatus execStatus;

    public void run() {
        try {
            Preconditions.checkNotNull(this.startingProcess, "起始节点 startingProcess 不能够为空");
            PipelineProcess currentProcess = this.startingProcess;
            boolean runSuccess = this.pipelineMapper.updateTaskRunning(this);
            if (!runSuccess) {
                return;
            }

            while (!currentProcess.isTerminal()) {
                ProcessParameter processParameter = this.buildProcessParameterMap(this.resultParam);
                this.pipelineMapper.updateProcessRunning(this.currentProcessId);
                ProcessResult processResult = currentProcess.process(processParameter);
                //log.("流水线 {}-{} 结束处理 {}，processResult={}", new Object[]{this.name, this.serial, String.valueOf(currentProcess.getName()), processResult.toString()});
                Preconditions.checkNotNull(processResult);
                if (this.isProcessPaused(processResult)) {
                    this.pipelineMapper.storePausedPipeline(this);
                    log.debug("流水线 {}-{} 暂停处理，processResult={}", new Object[]{this.name, this.serial, processResult.toString()});
                    break;
                }

                PipelineProcess nextProcess = processResult.getNextProcess();
                int nextProcessOrder = this.currentProcessOrder + 1;
                Integer nextProcessId = this.pipelineMapper.updateProcessDoneAndInitNextProcess(this.serial, this.currentProcessId, processResult, nextProcessOrder);
                currentProcess = nextProcess;
                this.currentProcessId = nextProcessId;
                this.currentProcessOrder = nextProcessOrder;
                this.resultParam = processResult.getResultParam();
                Preconditions.checkNotNull(nextProcess, "非终止节点 PipelineProcess 返回 nextProcess 为空");
                log.debug("流水线 {}-{} 执行下一个节点 {}", new Object[]{this.name, this.serial, String.valueOf(nextProcess.getName())});
            }

            if (currentProcess.isTerminal()) {
                currentProcess.process(this.buildProcessParameterMap(this.resultParam));
                this.pipelineMapper.updateTaskDone(this);
                this.pipelineMapper.updateProcessDone(this.currentProcessId);
                log.debug("流水线 {}-{} 完成处理", this.name, this.serial);
            }
        } catch (Exception var8) {
            if (var8 instanceof CjjClientException) {
                log.warn("客户端参数错误, serial = {}", this.serial, var8);
            } else {
                log.error("流水线处理异常: serial = {}", this.serial, var8);
            }

            this.pipelineMapper.storePausedPipeline(this);
        }

    }

    private ProcessParameter buildProcessParameterMap(Object resultParam) {
        return ProcessParameter.builder().requestParam(this.requestParam).order(this.currentProcessOrder).id(this.currentProcessId).resultParam(resultParam).pipelineTask(this).build();
    }

    private boolean isProcessPaused(ProcessResult processResult) {
        Preconditions.checkNotNull(processResult.getProcessExecStatus());
        return processResult.getProcessExecStatus().equals(PipelineExecStatus.PAUSED);
    }

    PipelineTask(PipelineMapper pipelineMapper, PipelineProcess startingProcess, Object requestParam, String serial, String name, Object resultParam, Integer currentProcessId, Integer currentProcessOrder, PipelineExecStatus execStatus) {
        this.pipelineMapper = pipelineMapper;
        this.startingProcess = startingProcess;
        this.requestParam = requestParam;
        this.serial = serial;
        this.name = name;
        this.resultParam = resultParam;
        this.currentProcessId = currentProcessId;
        this.currentProcessOrder = currentProcessOrder;
        this.execStatus = execStatus;
    }

    public static PipelineTask.PipelineTaskBuilder builder() {
        return new PipelineTask.PipelineTaskBuilder();
    }

    public String toString() {
        return "PipelineTask(pipelineMapper=" + this.pipelineMapper + ", startingProcess=" + this.getStartingProcess() + ", requestParam=" + this.getRequestParam() + ", serial=" + this.getSerial() + ", name=" + this.getName() + ", resultParam=" + this.resultParam + ", currentProcessId=" + this.getCurrentProcessId() + ", currentProcessOrder=" + this.getCurrentProcessOrder() + ", execStatus=" + this.getExecStatus() + ")";
    }

    public PipelineProcess getStartingProcess() {
        return this.startingProcess;
    }

    public Object getRequestParam() {
        return this.requestParam;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCurrentProcessId() {
        return this.currentProcessId;
    }

    public Integer getCurrentProcessOrder() {
        return this.currentProcessOrder;
    }

    public PipelineExecStatus getExecStatus() {
        return this.execStatus;
    }

    public static class PipelineTaskBuilder {
        private PipelineMapper pipelineMapper;
        private PipelineProcess startingProcess;
        private Object requestParam;
        private String serial;
        private String name;
        private Object resultParam;
        private Integer currentProcessId;
        private Integer currentProcessOrder;
        private PipelineExecStatus execStatus;

        PipelineTaskBuilder() {
        }

        public PipelineTask.PipelineTaskBuilder pipelineMapper(PipelineMapper pipelineMapper) {
            this.pipelineMapper = pipelineMapper;
            return this;
        }

        public PipelineTask.PipelineTaskBuilder startingProcess(PipelineProcess startingProcess) {
            this.startingProcess = startingProcess;
            return this;
        }

        public PipelineTask.PipelineTaskBuilder requestParam(Object requestParam) {
            this.requestParam = requestParam;
            return this;
        }

        public PipelineTask.PipelineTaskBuilder serial(String serial) {
            this.serial = serial;
            return this;
        }

        public PipelineTask.PipelineTaskBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PipelineTask.PipelineTaskBuilder resultParam(Object resultParam) {
            this.resultParam = resultParam;
            return this;
        }

        public PipelineTask.PipelineTaskBuilder currentProcessId(Integer currentProcessId) {
            this.currentProcessId = currentProcessId;
            return this;
        }

        public PipelineTask.PipelineTaskBuilder currentProcessOrder(Integer currentProcessOrder) {
            this.currentProcessOrder = currentProcessOrder;
            return this;
        }

        public PipelineTask.PipelineTaskBuilder execStatus(PipelineExecStatus execStatus) {
            this.execStatus = execStatus;
            return this;
        }

        public PipelineTask build() {
            return new PipelineTask(this.pipelineMapper, this.startingProcess, this.requestParam, this.serial, this.name, this.resultParam, this.currentProcessId, this.currentProcessOrder, this.execStatus);
        }

        public String toString() {
            return "PipelineTask.PipelineTaskBuilder(pipelineMapper=" + this.pipelineMapper + ", startingProcess=" + this.startingProcess + ", requestParam=" + this.requestParam + ", serial=" + this.serial + ", name=" + this.name + ", resultParam=" + this.resultParam + ", currentProcessId=" + this.currentProcessId + ", currentProcessOrder=" + this.currentProcessOrder + ", execStatus=" + this.execStatus + ")";
        }
    }
}
