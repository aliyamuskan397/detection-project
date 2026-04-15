package com.example.detection.controller;

import com.example.detection.service.DetectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetectionController {

    private final DetectionService detectionService;

    // Constructor Injection
    public DetectionController(DetectionService detectionService) {
        this.detectionService = detectionService;
    }

    // ✅ MAIN API (VIDEO PATH)
    @GetMapping("/detect-video")
    public String detectVideo(@RequestParam("video") String videoPath) {

        System.out.println("🔥 Received video path: " + videoPath);

        return "Detection API is working (Render)";
    }

    // ✅ TEST API (for checking server)
    @GetMapping("/test")
    public String test() {
        return "🚀 Detection Service Working!";
    }
}