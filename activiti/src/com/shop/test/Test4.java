package com.shop.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.h2.constant.SysProperties;
import org.h2.util.New;
import org.junit.Before;
import org.junit.Test;

public class Test4 {
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

	//zip格式部署
	@Test
	public void fun1() {
		
		/*
		 * Deployment deploy = processEngine.getRepositoryService() .createDeployment()
		 * .name("待办人分配表达式方式") .addClasspathResource("com/shop/diagram/Assignee.bpmn")
		 * .addClasspathResource("com/shop/diagram/Assignee.png") .deploy();
		 * System.out.println("部署id："+deploy.getId());
		 * System.out.println("部署名称："+deploy.getName());
		 */
		Deployment deploy = processEngine.getRepositoryService() .createDeployment()
				  .name("待办人分配监听器方式")
				  .addClasspathResource("com/shop/diagram/Assignee.bpmn")
				  .addClasspathResource("com/shop/diagram/Assignee.png") .deploy();
				  System.out.println("部署id："+deploy.getId());
				  System.out.println("部署名称："+deploy.getName());
		 
		
		/*
		 * InputStream inputStream =
		 * this.getClass().getClassLoader().getResourceAsStream(
		 * "com/shop/diagram/HelloWorld.zip"); ZipInputStream zipInputStream = new
		 * ZipInputStream(inputStream); Deployment deploy =
		 * processEngine.getRepositoryService() .createDeployment() .name("zip格式部署")
		 * .addZipInputStream(zipInputStream) .deploy();
		 * System.out.println("部署id："+deploy.getId());
		 * System.out.println("部署名称："+deploy.getName());
		 */
	}
	
	
	//启动流程
	@Test
	public void fun2() {
		String processDefinitionId = "myProcess";
		/*
		 * Map<String, Object> map = new HashMap<String, Object>(); map.put("userId",
		 * "张三");
		 */
		ProcessInstance processInstance = processEngine.getRuntimeService()
				.startProcessInstanceByKey(processDefinitionId);
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
		.taskAssignee("唐僧")
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
	
	//流程变量的设置和获取
	@Test
	public void setVariable() {
		String taskId = "804";
		processEngine.getTaskService().setVariable(taskId , "金额", 1000);
		processEngine.getTaskService().setVariable(taskId, "日期", new Date());
		System.out.println("设置完成");
	}
	
	@Test
	public void getVariable() {
		String taskId = "1002";
		Object variable = processEngine.getTaskService().getVariable(taskId, "金额");
		Object variable2 = processEngine.getTaskService().getVariable(taskId, "日期");
		System.out.println("获取到的金额是："+variable);
		System.out.println("获取到的日期是："+variable2);
	}
	
	//完成任务
	@Test
	public void fun4() {
		String taskId = "1604";
		
		  Map<String, Object> map = new HashMap<String, Object>(); map.put("message",
		  "不同意");
		 
		//完成任务
		//processEngine.getTaskService().complete(taskId);
		processEngine.getTaskService().complete(taskId, map);
		System.out.println("完成任务");
	}
	
	//查询流程定义列表
	@Test
	public void fun5() {
		List<ProcessDefinition> list = processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		.orderByProcessDefinitionName()
		.desc()
		.list();
		if(list!=null&&list.size()>0) {
			for (ProcessDefinition processDefinition : list) {
				System.out.println("流程定义id："+processDefinition.getId());
				System.out.println("流程定义名称："+processDefinition.getName());
				System.out.println("流程定义的key："+processDefinition.getKey());
				System.out.println("流程定义的版本："+processDefinition.getVersion());
				System.out.println("流程定义的部署id："+processDefinition.getDeploymentId());
				System.out.println("流程定义的bpmn文件名称："+processDefinition.getResourceName());
				System.out.println("流程定义的png文件名称："+processDefinition.getDiagramResourceName());
				System.out.println("--------------------------------");
			}
		}
	}
	
	//删除流程定义
	@Test
	public void fun6() {
		//普通删除，如果流程正在执行，则抛出异常，不强行删除
		String deploymentIdString = "501";
		processEngine.getRepositoryService()
		.deleteDeployment(deploymentIdString);
		System.out.println("删除成功");
	}
	
	@Test
	public void fun7() {
		//级联删除，如果流程正在执行，则强行删除
		String deploymentIdString = "501";
		processEngine.getRepositoryService()
		.deleteDeployment(deploymentIdString,true);
		System.out.println("删除成功");
	}
	
	//获取流程图和保存
	@Test
	public void fun8() throws IOException {
		String deploymentId = "701";
		String imgName = "";
		List<String> list = processEngine.getRepositoryService()
		.getDeploymentResourceNames(deploymentId);
		if(list != null && list.size()>0) {
			for (String name : list) {
				if(name.endsWith(".png")) {
					imgName = name;
				}
			}
		}
		//System.out.println(imgNameString);  //HelloWorld.png
		InputStream inputStream = processEngine.getRepositoryService().getResourceAsStream(deploymentId, imgName);
		File file = new File("D:\\upload\\temp\\img"+imgName);
		FileUtils.copyInputStreamToFile(inputStream, file);
		System.out.println("保存成功");
	}
	
	//查看历史任务
	@Test
	public void fun9() {
		//String taskAssignee = "陈小明";
		List<HistoricTaskInstance> list = processEngine.getHistoryService()
		.createHistoricTaskInstanceQuery()
		//.taskAssignee(taskAssignee )
		.list();
		if(list != null && list.size()>0) {
			for (HistoricTaskInstance historicTaskInstance : list) {
				System.out.println("历史任务id："+historicTaskInstance.getId());
				System.out.println("历史任务名称："+historicTaskInstance.getName());
				System.out.println("历史任务办理人："+historicTaskInstance.getAssignee());
				System.out.println("历史任务开始时间："+historicTaskInstance.getStartTime());
				System.out.println("历史任务结束时间："+historicTaskInstance.getEndTime());
				System.out.println("------------------");
			}
		}
	}

}
