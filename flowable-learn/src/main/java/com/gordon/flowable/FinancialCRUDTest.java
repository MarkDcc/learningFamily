package com.gordon.flowable;

import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.task.api.Task;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:dongchen
 * @Date: 2023/4/5 10:58
 */
public class FinancialCRUDTest {

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
	public void testDeployBPMN(){
		ProcessEngine processEngine = configuration.buildProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		Deployment deploy = repositoryService.createDeployment().addClasspathResource("financial.bpmn20.xml").deploy();
//		Deployment deployment = repositoryService.createDeploymentQuery().deploymentName("").singleResult();
		ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(deploy.getId()).singleResult();
		System.out.println("processDefinition.getKey() = " + processDefinition.getKey());
		System.out.println("deploy.getDeploymentTime() = " + deploy.getDeploymentTime());
	}

	public static void main(String[] args) {
		ProcessEngineConfiguration configuration = null;
		configuration = new StandaloneProcessEngineConfiguration();
		configuration.setJdbcUrl("jdbc:mysql://localhost:3306/flowable-learn1?serverTimezone=UTC&nullCatalogMeansCurrent=true")
				.setJdbcUsername("root")
				.setJdbcPassword("Admin_1234")
				.setJdbcDriver("com.mysql.cj.jdbc.Driver")
				.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
		ProcessEngine processEngine = configuration.buildProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		Scanner scanner= new Scanner(System.in);

		System.out.println("Who are you?");
		String employee = scanner.nextLine();

		System.out.println("How many holidays do you want to request?");
		Integer nrOfHolidays = Integer.valueOf(scanner.nextLine());

		System.out.println("Why do you need them?");
		String description = scanner.nextLine();
		Map<String,Object> variable = new HashMap<>();
		variable.put("approve", false);
		variable.put("employee",employee);
		variable.put("nrOfHolidays",nrOfHolidays);
		variable.put("description", description);
		variable.forEach((key,value)->{
			System.out.println(key+":"+value);
		});
		runtimeService.startProcessInstanceByKey("financialApprove",variable);
	}
	@Test
	public void testRunBPMN(){
		ProcessEngine processEngine = configuration.buildProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		Scanner scanner= new Scanner(System.in);

		System.out.println("Who are you?");
		String employee = scanner.nextLine();

		System.out.println("How many holidays do you want to request?");
		Integer nrOfHolidays = Integer.valueOf(scanner.nextLine());

		System.out.println("Why do you need them?");
		String description = scanner.nextLine();
		Map<String,Object> variable = new HashMap<>();
		variable.put("approve", false);
		variable.put("employee",employee);
		variable.put("nrOfHolidays",nrOfHolidays);
		variable.put("description", description);
		runtimeService.startProcessInstanceByKey("financialApprove",variable);

	}

	@Test
	public void testExecuteTask(){
		ProcessEngine processEngine = configuration.buildProcessEngine();
		TaskService taskService = processEngine.getTaskService();
		List<Task> tasks = taskService.createTaskQuery().processDefinitionKey("financialApprove").list();
		for (Task task : tasks) {
			if(task.getAssignee().equalsIgnoreCase("manger")){
				taskService.complete(task.getId());
			}
		}

	}
}
