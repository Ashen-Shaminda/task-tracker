package com.ashen_dissanayake.tasks.mappers;

import com.ashen_dissanayake.tasks.domain.dto.TaskListDto;
import com.ashen_dissanayake.tasks.domain.entities.TaskList;

public interface TaskListMapper {
   TaskList fromDto(TaskListDto taskListDto);

   TaskListDto toDto(TaskList taskList);

}
