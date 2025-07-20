package org.rushrepo.backend.dto;

import org.rushrepo.backend.enums.HealthState;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Data
@RequiredArgsConstructor
public class HealthDto {
    private final Instant timestamp;
    private final String message;
    private final HealthState state;
}
