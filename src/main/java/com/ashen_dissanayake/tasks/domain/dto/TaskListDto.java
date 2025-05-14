package com.ashen_dissanayake.tasks.domain.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.UUID;

public record TaskListDto(
        UUID id,

        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Description is required")
        String description,

        Integer count,
        Double progress,
        @Valid List<TaskDto> tasks
) {
}
