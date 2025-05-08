package com.ashen_dissanayake.tasks.services.impl;

import com.ashen_dissanayake.tasks.domain.entities.TaskList;
import com.ashen_dissanayake.tasks.repositories.TaskListRepository;
import com.ashen_dissanayake.tasks.services.TaskListService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskListServiceImpl implements TaskListService {

   private final TaskListRepository taskListRepository;

   public TaskListServiceImpl(TaskListRepository taskListRepository) {
      this.taskListRepository = taskListRepository;
   }

   @Override
   public List<TaskList> listTaskLists() {
      return taskListRepository.findAll();
   }

   @Override
   public TaskList createTaskList(TaskList taskList) {
      if (null != taskList.getId()) throw new IllegalArgumentException("Task list already has an id.");
      if (null == taskList.getTitle() || taskList.getTitle().isBlank())
         throw new IllegalArgumentException("Task list title cannot be blank.");

      LocalDateTime now = LocalDateTime.now();

      return taskListRepository.save(new TaskList(
              null,
              taskList.getTitle(),
              taskList.getDescription(),
              null,
              now,
              now
      ));
   }

   @Override
   public Optional<TaskList> getTaskList(UUID id) {
      return taskListRepository.findById(id);
   }

   @Override
   public TaskList updateTaskList(UUID id, TaskList taskList) {
      if (null == taskList.getId()) throw new IllegalArgumentException("Task list does not have an id.");

      if (Objects.equals(id, taskList.getId()))
         throw new IllegalArgumentException("Attempting to change task list id, this is not permitted.");

      TaskList existingTaskList = taskListRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task list does not exist."));

      existingTaskList.setTitle(taskList.getTitle());
      existingTaskList.setDescription(taskList.getDescription());
      existingTaskList.setUpdated(LocalDateTime.now());
      return taskListRepository.save(existingTaskList);
   }

   @Override
   public void deleteTaskList(UUID id) {
      taskListRepository.deleteById(id);
   }
}
