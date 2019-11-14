package com.shop.test;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;

public class Test2 {
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	//部署
	@Test
	public void fun1() {
		Deployment deploy = processEngine.getRepositoryService()
		.createDeployment()
		.name("helloworld入门程序")
		.addClasspathResource("com/shop/diagram/HelloWorld.bpmn")
		.addClasspathResource("com/shop/diagram/HelloWorld.png")
		.deploy();
		System.out.println("部署id："+deploy.getId());
		System.out.println("部署名称："+deploy.getName());
	}
	
	
	//启动流程
	@Test
	public void fun2() {
		ProcessInstance processInstance = processEngine.getRuntimeService()
				.startProcessInstanceByKey("helloworld");
		//流程定义id
		System.out.println("流程定义id:"+processInstance.getProcessDefinitionId());
		//流程实例id
		System.out.println("流程实例id:"+processInstance.getProcessInstanceId());
	}
	
	
	//查看当前待办人的个人任务
	@Test
	public void fun3() {
		List<Task> list = processEngine.getTaskService()
		.createTaskQuery()
		.taskAssignee("马蓉")
		.list();
		if(list!=null) {
			for (Task task : list) {
				System.out.println("当前任务的id："+task.getId());       
				System.out.println("当前任务的名称："+task.getName());    
				System.out.println("当前任务的创建时间："+task.getCreateTime());  
				System.out.println("当前任务的待办人："+task.getAssignee());  
			}
		}
	}
	
	//完成任务
	@Test
	public void fun4() {
		String taskId = "302";
		//完成任务
		processEngine.getTaskService().complete(taskId);
		System.out.println("完成任务");
	}

}
