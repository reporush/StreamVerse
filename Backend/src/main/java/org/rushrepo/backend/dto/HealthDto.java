package org.rushrepo.backend.dto;

import org.rushrepo.backend.enums.HealthState;

import java.time.Instant;

public class HealthDto {
    private final Instant timestamp;
    private final String message;
    private final HealthState state;

    public HealthDto(Instant timestamp, String message, HealthState state) {
        this.timestamp = timestamp;
        this.message = message;
        this.state = state;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HealthState getState() {
        return state;
    }
}
