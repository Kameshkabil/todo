package com.example.crud.todo.controller;

import com.example.crud.todo.entity.TaskInfo;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TodoController {
    public List<TaskInfo> taskList = new ArrayList<>();

    @GetMapping("/")
    public List<TaskInfo> getAllTasksInformation(){
        return taskList;
    }

    @GetMapping("/{id}")
    public TaskInfo getTaskInformationById(@PathVariable Long id){
        TaskInfo taskInformation = taskList.stream().filter(tasks->tasks.getId().equals(id)).findFirst().orElse(null);
        return taskInformation;

    }


    public long idCounter = 0;
    @PostMapping("/")
    public TaskInfo createTaskInformation(@RequestBody TaskInfo taskInfo){
        taskInfo.setId(idCounter++);
        taskList.add(taskInfo);
        return taskInfo;
    }


    @PutMapping("/{id}")
    public TaskInfo updateTaskInfoByID(@PathVariable Long id , @RequestBody TaskInfo taskInfo){
        TaskInfo taskInformation = taskList.stream().filter(tasks->tasks.getId().equals(id)).findFirst().orElse(null);

        if(taskInformation!=null){
            taskInformation.setName(taskInfo.getName());
            taskInformation.setDescription(taskInfo.getDescription());
            taskInformation.setStatus(taskInfo.getStatus());

        }

        return taskInformation;
    }


    @DeleteMapping("/{id}")
    public String deleteUsersById(@PathVariable Long id){
        taskList.removeIf(taskInfo->taskInfo.getId().equals(id));
        return "deleted successfully!";
    }

}