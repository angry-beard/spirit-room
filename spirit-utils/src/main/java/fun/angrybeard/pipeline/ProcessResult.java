package fun.angrybeard.pipeline;

public class ProcessResult {

    private PipelineProcess nextProcess;
    private PipelineExecStatus processExecStatus;
    private Object resultParam;

    ProcessResult(PipelineProcess nextProcess, PipelineExecStatus processExecStatus, Object resultParam) {
        this.nextProcess = nextProcess;
        this.processExecStatus = processExecStatus;
        this.resultParam = resultParam;
    }

    public static ProcessResult.ProcessResultBuilder builder() {
        return new ProcessResult.ProcessResultBuilder();
    }

    public PipelineProcess getNextProcess() {
        return this.nextProcess;
    }

    public PipelineExecStatus getProcessExecStatus() {
        return this.processExecStatus;
    }

    public Object getResultParam() {
        return this.resultParam;
    }

    public void setNextProcess(PipelineProcess nextProcess) {
        this.nextProcess = nextProcess;
    }

    public void setProcessExecStatus(PipelineExecStatus processExecStatus) {
        this.processExecStatus = processExecStatus;
    }

    public void setResultParam(Object resultParam) {
        this.resultParam = resultParam;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ProcessResult)) {
            return false;
        } else {
            ProcessResult other = (ProcessResult) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47:
                {
                    Object this$nextProcess = this.getNextProcess();
                    Object other$nextProcess = other.getNextProcess();
                    if (this$nextProcess == null) {
                        if (other$nextProcess == null) {
                            break label47;
                        }
                    } else if (this$nextProcess.equals(other$nextProcess)) {
                        break label47;
                    }

                    return false;
                }

                Object this$processExecStatus = this.getProcessExecStatus();
                Object other$processExecStatus = other.getProcessExecStatus();
                if (this$processExecStatus == null) {
                    if (other$processExecStatus != null) {
                        return false;
                    }
                } else if (!this$processExecStatus.equals(other$processExecStatus)) {
                    return false;
                }

                Object this$resultParam = this.getResultParam();
                Object other$resultParam = other.getResultParam();
                if (this$resultParam == null) {
                    if (other$resultParam != null) {
                        return false;
                    }
                } else if (!this$resultParam.equals(other$resultParam)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ProcessResult;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $nextProcess = this.getNextProcess();
        result = result * 59 + ($nextProcess == null ? 43 : $nextProcess.hashCode());
        Object $processExecStatus = this.getProcessExecStatus();
        result = result * 59 + ($processExecStatus == null ? 43 : $processExecStatus.hashCode());
        Object $resultParam = this.getResultParam();
        result = result * 59 + ($resultParam == null ? 43 : $resultParam.hashCode());
        return result;
    }

    public String toString() {
        return "ProcessResult(nextProcess=" + this.getNextProcess() + ", processExecStatus=" + this.getProcessExecStatus() + ", resultParam=" + this.getResultParam() + ")";
    }

    public static class ProcessResultBuilder {
        private PipelineProcess nextProcess;
        private PipelineExecStatus processExecStatus;
        private Object resultParam;

        ProcessResultBuilder() {
        }

        public ProcessResult.ProcessResultBuilder nextProcess(PipelineProcess nextProcess) {
            this.nextProcess = nextProcess;
            return this;
        }

        public ProcessResult.ProcessResultBuilder processExecStatus(PipelineExecStatus processExecStatus) {
            this.processExecStatus = processExecStatus;
            return this;
        }

        public ProcessResult.ProcessResultBuilder resultParam(Object resultParam) {
            this.resultParam = resultParam;
            return this;
        }

        public ProcessResult build() {
            return new ProcessResult(this.nextProcess, this.processExecStatus, this.resultParam);
        }

        public String toString() {
            return "ProcessResult.ProcessResultBuilder(nextProcess=" + this.nextProcess + ", processExecStatus=" + this.processExecStatus + ", resultParam=" + this.resultParam + ")";
        }
    }
}
