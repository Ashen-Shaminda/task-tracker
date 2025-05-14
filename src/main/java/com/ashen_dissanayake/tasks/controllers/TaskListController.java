package com.ashen_dissanayake.tasks.controllers;

import com.ashen_dissanayake.tasks.domain.dto.TaskListDto;
import com.ashen_dissanayake.tasks.domain.entities.TaskList;
import com.ashen_dissanayake.tasks.mappers.TaskListMapper;
import com.ashen_dissanayake.tasks.services.TaskListService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController {
   private final TaskListService taskListService;
   private final TaskListMapper taskListMapper;

   public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
      this.taskListService = taskListService;
      this.taskListMapper = taskListMapper;
   }

   @GetMapping
   public List<TaskListDto> listTaskLists() {
      return taskListService.listTaskLists()
              .stream()
              .map(taskListMapper::toDto)
              .toList();
   }

   @PostMapping
   public ResponseEntity<TaskListDto> createTaskList(@RequestBody @Valid TaskListDto taskListDto) {
      TaskList createdTaskList = taskListService.createTaskList(taskListMapper.fromDto(taskListDto));

      return ResponseEntity.status(HttpStatus.CREATED).body(taskListMapper.toDto(createdTaskList));
   }

   @GetMapping(path = "/{id}")
   public Optional<TaskListDto> getTaskListById(@PathVariable("id") UUID id) {
      return taskListService.getTaskList(id).map(taskListMapper::toDto);
   }

   @PutMapping(path = "/{id}")
   public ResponseEntity<TaskListDto> updateTaskList(@PathVariable("id") UUID id, @RequestBody @Valid TaskListDto taskListDto) {
      TaskList updatedTaskList = taskListService.updateTaskList(id, taskListMapper.fromDto(taskListDto));

      return ResponseEntity.status(HttpStatus.OK).body(taskListMapper.toDto(updatedTaskList));
   }

   @DeleteMapping(path = "/{id}")
   public ResponseEntity<Void> deleteTaskList(@PathVariable("id") UUID id) {
      taskListService.deleteTaskList(id);

      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }
}
