package com.app.fraudguardbackend.dto;

import java.util.List;

public class AnalyzeResponse {
    private int riskScore;
    private String level;
    private List<String> reasons;
    private List<String> advice;

    public AnalyzeResponse() {}

    public AnalyzeResponse(int riskScore, String level, List<String> reasons, List<String> advice) {
        this.riskScore = riskScore;
        this.level = level;
        this.reasons = reasons;
        this.advice = advice;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<String> getReasons() {
        return reasons;
    }

    public void setReasons(List<String> reasons) {
        this.reasons = reasons;
    }

    public List<String> getAdvice() {
        return advice;
    }

    public void setAdvice(List<String> advice) {
        this.advice = advice;
    }
}
