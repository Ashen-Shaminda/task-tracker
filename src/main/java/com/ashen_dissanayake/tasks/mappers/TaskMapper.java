package com.ashen_dissanayake.tasks.mappers;

import com.ashen_dissanayake.tasks.domain.dto.TaskDto;
import com.ashen_dissanayake.tasks.domain.entities.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {

   Task fromDto(TaskDto dto);

   TaskDto toDto(Task task);
}
