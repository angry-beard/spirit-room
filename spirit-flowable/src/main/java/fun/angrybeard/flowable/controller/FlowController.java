package fun.angrybeard.flowable.controller;


import fun.angrybeard.flowable.service.IFlowService;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.model.Process;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "flow")
public class FlowController {

    /**
     * 流程处理服务
     */
    @Autowired
    private IFlowService flowService;

    @PostMapping("/create")
    @ResponseBody
    public Map<String, Object> createFlow() {
        Map<String, Object> res = new HashMap<>();
        Map<String, Object> data = new HashMap<>();

        String flowPath = "D:\\geek\\projects\\spirit-room\\spirit-flowable\\src\\main\\resources\\ExpenseProcess.bpmn20.xml";

        Map<String, Object> createRes = flowService.createFlow(flowPath);

        if (null == createRes) {
            res.put("msg", "创建流程失败");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }
        List<Process> processes = (List<Process>) createRes.get("processes");

        ArrayList<String> ids = new ArrayList<>();
        for (Process process : processes) {
            ids.add(process.getId());
        }
        data.put("processKeys", ids);
        data.put("deployId", ((Deployment) createRes.get("deployment")).getId());
        res.put("data", data);
        res.put("msg", "创建流程成功");
        res.put("res", "1");
        return res;
    }

    @RequestMapping("/start")
    @ResponseBody
    public Map<String, Object> startFlow(@RequestBody @RequestParam(required = false) Map<String, String> paras) {
        Map<String, Object> res = new HashMap<>();
        Map<String, String> data = new HashMap<>();

        /*if (null == paras) {
            res.put("msg", "启动流程失败");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }*/
        paras.put("processKey", "test_bpmn");
        String processKey = paras.get("processKey");

        if (StringUtils.isEmpty(processKey)) {
            res.put("msg", "启动流程失败");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }

        Map<String, Object> flowParas = new HashMap<>();
        flowParas.putAll(paras);
        ProcessInstance processInstance = flowService.startFlow(processKey, flowParas);
        if (null == processInstance) {
            res.put("msg", "启动流程失败");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }
        data.put("processId", processInstance.getId());
        res.put("msg", "启动流程成功");
        res.put("res", "1");
        res.put("data", data);
        return res;
    }

    @GetMapping(value = "processDiagram")
    public void genProcessDiagram(HttpServletResponse httpServletResponse, String processId) throws Exception {
        flowService.genProcessDiagram(httpServletResponse, processId);
    }

    @RequestMapping("complete")
    @ResponseBody
    public Map<String, Object> completeTask(@RequestBody @RequestParam(required = false) Map<String, String> paras) {
        Map<String, Object> res = new HashMap<>();
        Map<String, String> data = new HashMap<>();

        /*if (null == paras) {
            res.put("msg", "请输入任务参数");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }*/
        paras.put("taskId", "b0d022e9-0952-11ea-8682-e2b5d7343a01");
        String taskId = paras.get("taskId");
        if (StringUtils.isEmpty(taskId)) {
            res.put("msg", "请输入任务ID");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }

        Map<String, Object> flowParas = new HashMap<>();
        flowParas.putAll(paras);
        boolean bok = flowService.completeTask(taskId, flowParas);

        if (bok) {
            data.put("taskId", taskId);
            res.put("msg", "启动流程成功");
            res.put("res", "1");
        } else {
            data.put("taskId", taskId);
            res.put("msg", "启动流程失败");
            res.put("res", "0");
        }

        res.put("data", data);
        return res;
    }

    @RequestMapping("/accept")
    @ResponseBody
    public Map<String, Object> acceptTask(@RequestBody @RequestParam(required = false) Map<String, String> paras) {
        Map<String, Object> res = new HashMap<>();
        Map<String, String> data = new HashMap<>();

        if (null == paras) {
            res.put("msg", "请输入任务参数");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }

        paras.put("taskId", "b0d022e9-0952-11ea-8682-e2b5d7343a01");
        String taskId = paras.get("taskId");
        if (StringUtils.isEmpty(taskId)) {
            res.put("msg", "请输入任务ID");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }

        Map<String, Object> flowParas = new HashMap<>();
        flowParas.putAll(paras);
        flowParas.put("outcome", "通过");
        boolean bok = flowService.completeTask(taskId, flowParas);

        if (bok) {
            data.put("taskId", taskId);
            res.put("msg", "通过任务成功");
            res.put("res", "1");
        } else {
            data.put("taskId", taskId);
            res.put("msg", "通过任务失败");
            res.put("res", "0");
        }

        res.put("data", data);
        return res;
    }


    @RequestMapping("/reject")
    @ResponseBody
    public Map<String, Object> rejectTask(@RequestBody @RequestParam(required = false) Map<String, String> paras) {
        Map<String, Object> res = new HashMap<>();
        Map<String, String> data = new HashMap<>();

        if (null == paras) {
            res.put("msg", "请输入任务参数");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }

        String taskId = paras.get("taskId");
        if (StringUtils.isEmpty(taskId)) {
            res.put("msg", "请输入任务ID");
            res.put("res", "0");
            res.put("data", data);
            return res;
        }

        Map<String, Object> flowParas = new HashMap<>();
        flowParas.putAll(paras);
        flowParas.put("outcome", "拒绝");
        boolean bok = flowService.completeTask(taskId, flowParas);

        if (bok) {
            data.put("taskId", taskId);
            res.put("msg", "拒绝任务成功");
            res.put("res", "1");
        } else {
            data.put("taskId", taskId);
            res.put("msg", "拒绝任务失败");
            res.put("res", "0");
        }

        res.put("data", data);
        return res;
    }

}
