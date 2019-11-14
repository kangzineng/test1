package com.shop.task;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTask implements TaskListener{

	@Override
	public void notify(DelegateTask delegateTask) {
		delegateTask.setAssignee("秋香");
		// TODO Auto-generated method stub
		
	}

}
