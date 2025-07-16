package org.rushrepo.backend.service;

import org.rushrepo.backend.dto.HealthDto;
import org.rushrepo.backend.enums.HealthState;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;

@Service
public class HealthService {
    private final Clock clock;

    // Use dependency injection
    public HealthService(Clock clock) {
        this.clock = clock;
    }

    public HealthDto getHealthStatus(){
        return new HealthDto(
                Instant.now(clock),
                "StreamVerse API is running",
                HealthState.UP
        );
    }
}
