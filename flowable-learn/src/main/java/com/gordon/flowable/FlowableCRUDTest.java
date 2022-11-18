package com.gordon.flowable;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author dongchen
 * @Data 2022/10/20
 * @Time 17:52
 */
public class FlowableCRUDTest {

	ProcessEngineConfiguration configuration = null;

	@Before
	public void test(){
		configuration = new StandaloneProcessEngineConfiguration();
		configuration.setJdbcUrl("jdbc:mysql://localhost:3306/flowable-learn1?serverTimezone=UTC&nullCatalogMeansCurrent=true")
				.setJdbcUsername("root")
				.setJdbcPassword("Admin_1234")
				.setJdbcDriver("com.mysql.cj.jdbc.Driver")
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
	}

	@Test
	public void testCreateProcessEngine(){
		ProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration();
		 configuration.setJdbcUrl("jdbc:mysql://localhost:3306/flowable-learn1?serverTimezone=UTC&nullCatalogMeansCurrent=true")
				.setJdbcUsername("root")
				.setJdbcPassword("Admin_1234")
				.setJdbcDriver("com.mysql.cj.jdbc.Driver")
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		ProcessEngine processEngine = configuration.buildProcessEngine();
		System.out.println("processEngine = " + processEngine);
		System.out.println(processEngine.getManagementService().getProperties().size());
		Map<String, String> properties = processEngine.getManagementService().getProperties();
		Set<Map.Entry<String, String>> entries = properties.entrySet();
		for (Map.Entry<String, String> entry : entries) {
			System.out.println(entry.getKey()+"----"+entry.getValue());
		}
	}

	@Test
	public void testDeployBPMN(){
		ProcessEngine processEngine = configuration.buildProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deploy =
				repositoryService.createDeployment().addClasspathResource("test.bpmn20.xml").deploy();
		ProcessDefinition processDefinition =
				repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
		System.out.println("processDefinition.getDeploymentId() = " + processDefinition.getDeploymentId());
		System.out.println("processDefinition.getId() = " + processDefinition.getId());
		System.out.println("processDefinition.getName() = " + processDefinition.getName());
		System.out.println("processDefinition.getKey() = " + processDefinition.getKey());
		System.out.println("deploy.getName() = " + deploy.getName());
		System.out.println("deploy.getId() = " + deploy.getId());
		System.out.println("deploy.getEngineVersion() = " + deploy.getEngineVersion());
	}

	@Test
	public void testRunBPMN(){
		ProcessEngine processEngine = configuration.buildProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		Map<String,Object> variables = new HashMap<>();
		variables.put("employee", "zhangsan");
		variables.put("nrOfHolidays", "3");
		variables.put("description", "想休息一下");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("test", variables);
		System.out.println("processInstance.getBusinessKey() = " + processInstance.getBusinessKey());
		System.out.println("processInstance.getProcessDefinitionKey() = " + processInstance.getProcessDefinitionKey());
		for (Map.Entry<String, Object> entry : processInstance.getProcessVariables().entrySet()) {
			System.out.println(entry.getKey()+"==="+entry.getValue());
		}
	}

	@Test
	public void testExecuteTask(){
		ProcessEngine processEngine = configuration.buildProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("test").taskAssignee(
				"boss").list();
		for (Task task : tasks) {
			System.out.println("task.getAssignee() = " + task.getAssignee());
			if(task.getAssignee().equalsIgnoreCase("boss")){
				if(task.getId().equals("12503")){
					taskService.complete(task.getId());
					continue;
				}
				Map<String, Object> variables = new HashMap<>();
				variables.put("approve",true);
				taskService.complete(task.getId(),variables);
			}
		}
	}

	@Test
	public void testGetHistory(){
		ProcessEngine processEngine = configuration.buildProcessEngine();
		HistoryService historyService = processEngine.getHistoryService();
		List<HistoricActivityInstance> list =
				historyService.createHistoricActivityInstanceQuery().processDefinitionId("holidayRequest:5:17503").finished()
						.orderByHistoricActivityInstanceEndTime()
						.asc()
						.list();
		for (HistoricActivityInstance historicActivityInstance : list) {

			System.out.println("historicActivityInstance.getActivityName() = " + historicActivityInstance.getActivityName());
			System.out.println("historicActivityInstance.getActivityId() = " + historicActivityInstance.getActivityId());
			System.out.println("historicActivityInstance.getDurationInMillis() = " + historicActivityInstance.getDurationInMillis());
		}
	}


}
