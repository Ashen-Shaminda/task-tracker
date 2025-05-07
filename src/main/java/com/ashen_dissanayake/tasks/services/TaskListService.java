package com.ashen_dissanayake.tasks.services;

import com.ashen_dissanayake.tasks.domain.entities.TaskList;

import java.util.List;

public interface TaskListService {
   List<TaskList> listTaskLists();

   TaskList createTaskList(TaskList taskList);
}
