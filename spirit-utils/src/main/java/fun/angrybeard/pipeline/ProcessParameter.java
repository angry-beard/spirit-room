package fun.angrybeard.pipeline;

public class ProcessParameter {

    private PipelineTask pipelineTask;
    private Object requestParam;
    private Integer order;
    private Integer id;
    private Object resultParam;

    private ProcessParameter(PipelineTask pipelineTask, Object requestParam, Integer order, Integer id, Object resultParam) {
        this.pipelineTask = pipelineTask;
        this.requestParam = requestParam;
        this.order = order;
        this.id = id;
        this.resultParam = resultParam;
    }

    static ProcessParameter.ProcessParameterBuilder builder() {
        return new ProcessParameter.ProcessParameterBuilder();
    }

    public PipelineTask getPipelineTask() {
        return this.pipelineTask;
    }

    public Object getRequestParam() {
        return this.requestParam;
    }

    public Integer getOrder() {
        return this.order;
    }

    public Integer getId() {
        return this.id;
    }

    public Object getResultParam() {
        return this.resultParam;
    }

    public static class ProcessParameterBuilder {
        private PipelineTask pipelineTask;
        private Object requestParam;
        private Integer order;
        private Integer id;
        private Object resultParam;

        ProcessParameterBuilder() {
        }

        ProcessParameter.ProcessParameterBuilder pipelineTask(PipelineTask pipelineTask) {
            this.pipelineTask = pipelineTask;
            return this;
        }

        ProcessParameter.ProcessParameterBuilder requestParam(Object requestParam) {
            this.requestParam = requestParam;
            return this;
        }

        ProcessParameter.ProcessParameterBuilder order(Integer order) {
            this.order = order;
            return this;
        }

        ProcessParameter.ProcessParameterBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        ProcessParameter.ProcessParameterBuilder resultParam(Object resultParam) {
            this.resultParam = resultParam;
            return this;
        }

        ProcessParameter build() {
            return new ProcessParameter(this.pipelineTask, this.requestParam, this.order, this.id, this.resultParam);
        }

        public String toString() {
            return "ProcessParameter.ProcessParameterBuilder(pipelineTask=" + this.pipelineTask + ", requestParam=" + this.requestParam + ", order=" + this.order + ", id=" + this.id + ", resultParam=" + this.resultParam + ")";
        }
    }
}
