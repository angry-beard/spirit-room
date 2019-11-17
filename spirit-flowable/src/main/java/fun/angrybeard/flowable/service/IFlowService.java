package fun.angrybeard.flowable.service;

import org.flowable.engine.runtime.ProcessInstance;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface IFlowService {

    /**
     * 部署工作流
     */
    Map<String, Object> createFlow(String filePath);

    /**
     * 启动工作流
     */
    ProcessInstance startFlow(String processKey, Map<String, Object> paras);

    /**
     * 查看流程图
     *
     * @param httpServletResponse
     * @param processId
     */
    void genProcessDiagram(HttpServletResponse httpServletResponse, String processId);

    /**
     * 完成流程
     *
     * @param taskId
     * @param flowParas
     * @return
     */
    boolean completeTask(String taskId, Map<String, Object> flowParas);
}
