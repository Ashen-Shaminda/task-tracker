package com.ashen_dissanayake.tasks.mappers;

import com.ashen_dissanayake.tasks.domain.dto.TaskDto;
import com.ashen_dissanayake.tasks.domain.entities.Task;

public interface TaskMapper {
   Task fromDto(TaskDto dto);
   
   TaskDto toDto(Task task);
}
