package com.ashen_dissanayake.tasks.domain.dto;

import com.ashen_dissanayake.tasks.domain.entities.TaskPriority;
import com.ashen_dissanayake.tasks.domain.entities.TaskStatus;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDto(
        UUID id,

        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Description is required")
        String description,

        @Future(message = "Due date must be in the future.")
        LocalDateTime dueDate,

        TaskPriority priority,
        TaskStatus status
) {
}
