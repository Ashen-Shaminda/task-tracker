package com.ashen_dissanayake.tasks.controllers;

import com.ashen_dissanayake.tasks.domain.dto.TaskDto;
import com.ashen_dissanayake.tasks.domain.entities.Task;
import com.ashen_dissanayake.tasks.mappers.TaskMapper;
import com.ashen_dissanayake.tasks.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/task-lists/{task_list_id}/tasks")
public class TaskController {
   private final TaskService taskService;
   private final TaskMapper taskMapper;

   public TaskController(TaskService taskService, TaskMapper taskMapper) {
      this.taskService = taskService;
      this.taskMapper = taskMapper;
   }

   @GetMapping
   public List<TaskDto> listTasks(@PathVariable("task_list_id") UUID taskListId) {
      return taskService.listTasks(taskListId)
              .stream()
              .map(taskMapper::toDto)
              .toList();
   }

   @PostMapping
   public ResponseEntity<TaskDto> createTask(@PathVariable("task_list_id") UUID taskListId, @RequestBody TaskDto taskDto) {
      Task createdTask = taskService.createTask(taskListId, taskMapper.fromDto(taskDto));

      return new ResponseEntity<>(taskMapper.toDto(createdTask), HttpStatus.CREATED);
   }

   @GetMapping(path = "/{task_id}")
   public Optional<TaskDto> getTask(@PathVariable("task_list_id") UUID taskListId, @PathVariable("task_id") UUID taskId) {
      return taskService.getTask(taskListId, taskId).map(taskMapper::toDto);
   }

   @PutMapping(path = "/{task_id}")
   public ResponseEntity<TaskDto> updateTask(@PathVariable("task_list_id") UUID taskListId, @PathVariable("task_id") UUID taskId, @Valid @RequestBody TaskDto taskDto) {
      Task updatedTask = taskService.updateTask(taskListId, taskId, taskMapper.fromDto(taskDto));

      return new ResponseEntity<>(taskMapper.toDto(updatedTask), HttpStatus.OK);
   }

   @DeleteMapping(path = "/{task_id}")
   public void deleteTask(@PathVariable("task_list_id") UUID taskListId, @PathVariable("task_id") UUID taskId) {
      taskService.deleteTask(taskListId, taskId);
   }
}
