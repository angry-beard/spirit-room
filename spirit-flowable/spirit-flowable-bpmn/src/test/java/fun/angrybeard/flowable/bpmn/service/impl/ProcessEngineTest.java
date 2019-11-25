package fun.angrybeard.flowable.bpmn.service.impl;

import fun.angrybeard.flowable.bpmn.BPMNApplication;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.*;
import org.flowable.engine.repository.DeploymentBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BPMNApplication.class})
public class ProcessEngineTest {

    private ProcessEngine processEngine;
    private RepositoryService repositoryService;
    private DynamicBpmnService dynamicBpmnService;
    private FormService formService;
    private IdentityService identityService;
    private ManagementService managementService;
    private HistoryService historyService;
    private TaskService taskService;

    @Before
    public void initProcessEngine() {
        processEngine = ProcessEngines.getDefaultProcessEngine();
        log.info(processEngine + "");
        repositoryService = processEngine.getRepositoryService();
        log.info(repositoryService + "");
    }

    @Test
    public void deploymentBuild() {
        DeploymentBuilder builder = repositoryService.createDeployment()
                .category("测试分类")
                .name("名称");
        log.info(builder + "");
    }
}