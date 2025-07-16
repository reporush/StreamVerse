package org.rushrepo.backend.controller;

import org.rushrepo.backend.dto.HealthDto;
import org.rushrepo.backend.service.HealthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {
    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping
    public ResponseEntity<HealthDto> checkHealth(){
        HealthDto healthStatus = healthService.getHealthStatus();
        return ResponseEntity.ok(healthStatus);
    }
}
