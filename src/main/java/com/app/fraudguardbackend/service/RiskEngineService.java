package com.app.fraudguardbackend.service;

import com.app.fraudguardbackend.dto.AnalyzeRequest;
import com.app.fraudguardbackend.dto.AnalyzeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RiskEngineService {

    public AnalyzeResponse analyze(AnalyzeRequest req) {

        int score = 0;
        List<String> reasons = new ArrayList<>();

        String text = (req.getText() == null ? "" : req.getText()).toLowerCase();
        String title = (req.getTitle() == null ? "" : req.getTitle()).toLowerCase();

        if (text.contains("acil") || title.contains("acil")) {
            score += 20;
            reasons.add("Acil dil kullanımı");
        }
        if (text.contains("ödül") || text.contains("odul")) {
            score += 30;
            reasons.add("Ödül vaadi");
        }
        if (text.contains("bit.ly") || text.contains("tinyurl")) {
            score += 30;
            reasons.add("Kısa link kullanımı");
        }
        if (text.contains("şifre") || text.contains("ifre") ||
                text.contains("iban") || text.contains("kart")) {
            score += 40;
            reasons.add("Finansal bilgi talebi");
        }
        if (req.getAppPackage() != null &&
                req.getAppPackage().contains("telegram")) {
            score += 10;
            reasons.add("Mesajlaşma uygulaması");
        }

        if (score > 100) score = 100;

        String level =
                score >= 90 ? "CRITICAL" :
                        score >= 70 ? "HIGH" :
                                score >= 50 ? "MEDIUM" :
                                        score >= 20 ? "LOW" :
                                                "SAFE";

        List<String> advice = List.of(
                "Linke tıklamayın",
                "Göndereni arayarak doğrulayın",
                "Kişisel veya finansal bilgi paylaşmayın"
        );

        return new AnalyzeResponse(score, level, reasons, advice);
    }
}
