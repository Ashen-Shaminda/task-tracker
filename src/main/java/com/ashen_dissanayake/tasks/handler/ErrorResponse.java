package com.ashen_dissanayake.tasks.handler;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
