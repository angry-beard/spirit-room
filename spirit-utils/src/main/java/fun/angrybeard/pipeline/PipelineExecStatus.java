package fun.angrybeard.pipeline;

import jdk.nashorn.internal.objects.annotations.Getter;

public enum PipelineExecStatus {

    INIT,
    RUNNING,
    PAUSED,
    DONE;

    private PipelineExecStatus() {
    }
}
