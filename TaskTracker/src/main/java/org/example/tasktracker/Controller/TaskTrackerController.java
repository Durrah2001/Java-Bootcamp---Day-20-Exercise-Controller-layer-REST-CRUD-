package org.example.tasktracker.Controller;

import org.example.tasktracker.ApiResponse.ApiResponse;
import org.example.tasktracker.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task-tracker")

public class TaskTrackerController {

    ArrayList <Task> taskTrackers = new ArrayList<>();


    @PostMapping(path = "/add")
    public ApiResponse createTask(@RequestBody Task taskTracker) {

        taskTrackers.add(taskTracker);
        return new ApiResponse("Task created successfully");
    }


    @GetMapping(path = "/get")
    public ArrayList<Task> displayTask(){

         return taskTrackers;
    }


    @PutMapping(path = "/update/{index}")
    public ApiResponse updateTask(@PathVariable int index, @RequestBody Task taskTracker) {

        taskTrackers.set(index, taskTracker);
        return new ApiResponse("Task updated successfully");

    }

    @DeleteMapping(path = "/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index) {
        taskTrackers.remove(index);
        return new ApiResponse("Task deleted successfully");
    }


    @PutMapping(path = "/update-status/{status}")
    public ApiResponse checkStatus(@PathVariable String status) {

        for (Task task : taskTrackers) {
            if(task.getStatus().equalsIgnoreCase("Not done")) {
                task.setStatus("Done");
            }
        }
        return new ApiResponse("Task status updated to Done successfully");
    }



    @GetMapping(path = "/title/{title}")
    public ApiResponse getByTitle(@PathVariable String title) {

        for (Task task : taskTrackers) {
            if(task.getTitle().equalsIgnoreCase(title))
                return new ApiResponse("Task with this title found successfully");

        }
        return new ApiResponse("Task with this title not found");
    }











} //End controller
