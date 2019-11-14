package com.shop.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;

public class Test1 {
	public static void main(String[] args) {
		//fun1();
		//fun2();
		fun3();
	}

	public static void fun3() {
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		System.out.println(processEngine);
	}

	public static void fun2() {
		ProcessEngineConfiguration processEngineConfiguration = 
				ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println(processEngine);
	}

	public static void fun1() {
		//创建流程引擎配置对象，使用流程引擎配置对象创建数据库
		ProcessEngineConfiguration processEngineConfiguration = 
				ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activiti_demo");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("123");
		
		// 设置建表的策略

				/*
				 * 
				 * //每次都要先删除表，再去创建
				 *		 * DB_SCHEMA_UPDATE_FALSE = "false";
				 * 
				 * // 如果不存在表，就直接抛出异常 public static final String
				 * DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";
				 * 
				 * 
				 *如果不存在表，就创建表，如果存在，就直接使用！ public static final String

				 * public static final String DB_SCHEMA_UPDATE_TRUE = "true";
				 * 
				 **/
		processEngineConfiguration.setDatabaseSchemaUpdate("true");
		// 使用流程引擎配置对象创建 流程引擎对象
		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
		System.out.println(processEngine);
	}
	
	

}
