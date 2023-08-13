package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priyank")
public class MyController {
	
	@Autowired
	private ServiceImpl service;
	
	@RequestMapping(value = "/makeTask" , method = RequestMethod.POST)
	public TaskDTO makeTask(@RequestBody TaskDTO task)
	{
		return service.makeTask(task);
	}
	
	@RequestMapping(value = "/getTasks" , method = RequestMethod.GET)
	public  List <TaskDTO>  getAllTasks() 
	  {
		List<TaskDTO> tasks = service.findAll();
	    return (tasks);
	  }
	
	
	@RequestMapping(value = "/deleteTask/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity< String > deleteTaskById(@PathVariable int id) 
	  {
	    service.deleteTaskById(id);
		return ResponseEntity.ok("Task deleted successfully");
	  }
	
	@RequestMapping(value = "/updateTask/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody TaskDTO updatedTask) {
        Optional<TaskDTO> existingTaskOptional = service.getTaskById(id);

        if (existingTaskOptional.isPresent()) {
            TaskDTO existingTask = existingTaskOptional.get();
            existingTask.setTask(updatedTask.getTask());
            existingTask.setPerformer(updatedTask.getPerformer());
            service.updateTask(existingTask);
            return ResponseEntity.ok("Task updated successfully");
        } else 
        {
            return ResponseEntity.notFound().build();
        }
    }
	
}
	
	

