package com.ashen_dissanayake.tasks.mappers;

import com.ashen_dissanayake.tasks.domain.dto.TaskListDto;
import com.ashen_dissanayake.tasks.domain.entities.Task;
import com.ashen_dissanayake.tasks.domain.entities.TaskList;
import com.ashen_dissanayake.tasks.domain.entities.TaskStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", uses = TaskMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskListMapper {
   TaskList fromDto(TaskListDto taskListDto);

   @Mapping(target = "count", expression = "java(taskList.getTasks() != null ? taskList.getTasks().size() : 0)")
   @Mapping(target = "progress", source = "tasks", qualifiedByName = "calculateTaskListProgress")
   TaskListDto toDto(TaskList taskList);

   @Named("calculateTaskListProgress")
   default Double calculateTaskListProgress(List<Task> tasks) {
      if (tasks == null || tasks.isEmpty()) return null;

      long closedTaskCount = tasks.stream()
              .filter(task -> TaskStatus.CLOSED == task.getStatus())
              .count();

      return (double) closedTaskCount / tasks.size();
   }
}
