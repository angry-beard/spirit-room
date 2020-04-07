package fun.angrybeard.pipeline;

public interface PipelineProcess {

    ProcessResult process(ProcessParameter var1);

    boolean isTerminal();

    String getName();
}
