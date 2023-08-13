package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {
	
	@Autowired
	private TaskDao taskdao;	
   
   public TaskDTO makeTask(TaskDTO task)
   {
	   taskdao.save(task);
	   return task;
   }
   

	public List<TaskDTO> findAll() 
	{	
		List<TaskDTO> tasks = taskdao.findAll();
		return tasks;
	}
	
	public void deleteTaskById(int id)
	{
		taskdao.deleteById(id);
		
	}
	
	public Optional<TaskDTO> getTaskById(int id) 
	{
	    return taskdao.findById(id);
	}


	
	public TaskDTO updateTask(TaskDTO task)
	{
		taskdao.save(task);
		return task;
	}
	
}
