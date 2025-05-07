package com.ashen_dissanayake.tasks.controllers;

import com.ashen_dissanayake.tasks.domain.dto.TaskListDto;
import com.ashen_dissanayake.tasks.domain.entities.TaskList;
import com.ashen_dissanayake.tasks.mappers.TaskListMapper;
import com.ashen_dissanayake.tasks.services.TaskListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
   public ResponseEntity<TaskListDto> createTaskList(@RequestBody TaskListDto taskListDto) {
      TaskList createdTaskList = taskListService.createTaskList(taskListMapper.fromDto(taskListDto));
      TaskListDto responseDto = taskListMapper.toDto(createdTaskList);

      return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
   }
}
