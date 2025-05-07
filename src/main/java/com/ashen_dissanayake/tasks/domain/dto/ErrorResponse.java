package com.ashen_dissanayake.tasks.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
