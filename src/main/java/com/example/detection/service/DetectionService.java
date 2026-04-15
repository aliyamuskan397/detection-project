package com.example.detection.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class DetectionService {

    public String runDetection(String videoPath) {
        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "C:\\Users\\WINDOWS\\AppData\\Local\\Programs\\Python\\Python311\\python.exe",
                    "D:/project-11-at-2026-04-07-14-50-7c1f887a/detect_video.py",
                    videoPath
            );

            pb.redirectErrorStream(true);

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;
            StringBuilder output = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                System.out.println("PYTHON: " + line);
                output.append(line).append("\n");
            }

            int exitCode = process.waitFor();  // ✅ ADDED
            System.out.println("Process exited with code: " + exitCode);

            return output.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error running detection";
        }
    }
}