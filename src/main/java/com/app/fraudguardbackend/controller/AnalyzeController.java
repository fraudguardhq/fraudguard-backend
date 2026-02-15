package com.app.fraudguardbackend.controller;

import com.app.fraudguardbackend.dto.AnalyzeRequest;
import com.app.fraudguardbackend.dto.AnalyzeResponse;
import com.app.fraudguardbackend.service.RiskEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnalyzeController {

    private final RiskEngineService riskEngineService;

    public AnalyzeController(RiskEngineService riskEngineService) {
        this.riskEngineService = riskEngineService;
    }

    @PostMapping("/analyze")
    public AnalyzeResponse analyze(@RequestBody AnalyzeRequest request) {
        return riskEngineService.analyze(request);
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
