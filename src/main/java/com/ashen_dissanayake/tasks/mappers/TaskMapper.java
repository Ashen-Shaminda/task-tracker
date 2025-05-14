package com.ashen_dissanayake.tasks.mappers;

import com.ashen_dissanayake.tasks.domain.dto.TaskDto;
import com.ashen_dissanayake.tasks.domain.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {

   Task fromDto(TaskDto dto);

   TaskDto toDto(Task task);
}
