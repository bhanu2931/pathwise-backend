package com.pathwise.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AIController {

    @GetMapping("/suggest")
    public String suggest(@RequestParam String interest) {

        String input = interest.toLowerCase();

        // 💻 SOFTWARE / CODING
        if (input.contains("code") || input.contains("java") || input.contains("programming")) {
            return "Based on your interest in coding, you should explore Software Engineering 💻. "
                 + "Start with Java, Data Structures, and frameworks like Spring Boot. "
                 + "You can also learn React for full-stack development.";
        }

        // 📊 DATA SCIENCE
        else if (input.contains("data") || input.contains("analysis")) {
            return "You seem interested in Data Science 📊. "
                 + "Focus on Python, SQL, Statistics, and tools like Pandas and Machine Learning. "
                 + "This field has high demand and strong career growth.";
        }

        // 🎨 UI/UX DESIGN
        else if (input.contains("design") || input.contains("ui") || input.contains("ux")) {
            return "UI/UX Design 🎨 could be a great choice for you. "
                 + "Learn Figma, design thinking, and user research. "
                 + "Creative skills + usability focus are key here.";
        }

        // 🤖 AI / ML
        else if (input.contains("ai") || input.contains("machine learning")) {
            return "AI & Machine Learning 🤖 is one of the fastest-growing fields. "
                 + "Start with Python, then explore TensorFlow, Deep Learning, and NLP.";
        }

        // ☁️ CLOUD
        else if (input.contains("cloud") || input.contains("aws")) {
            return "Cloud Computing ☁️ is a powerful career path. "
                 + "Learn AWS, Docker, Kubernetes, and DevOps practices.";
        }

        // 🔐 CYBERSECURITY
        else if (input.contains("security") || input.contains("hacking")) {
            return "Cybersecurity 🔐 is a critical field today. "
                 + "Focus on networking, ethical hacking, and security protocols.";
        }

        // 📱 MOBILE DEV
        else if (input.contains("mobile") || input.contains("android") || input.contains("app")) {
            return "Mobile Development 📱 is a great option. "
                 + "Learn Kotlin (Android) or Swift (iOS), or React Native for cross-platform apps.";
        }

        // 📈 PRODUCT MANAGEMENT
        else if (input.contains("management") || input.contains("product")) {
            return "Product Management 📈 could suit you. "
                 + "Focus on strategy, user needs, and Agile methodologies.";
        }

        // 🌍 DEFAULT RESPONSE
        return "Based on your interest, you can explore fields like Software Engineering 💻, "
             + "Data Science 📊, AI 🤖, or UI/UX Design 🎨. "
             + "Try exploring what excites you most and start building skills step by step.";
    }
}