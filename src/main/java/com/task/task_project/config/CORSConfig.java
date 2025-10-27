package com.task.task_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOriginPatterns(  // CAMBIA allowedOrigins POR allowedOriginPatterns
                            "http://localhost:3000",
                            "http://localhost:5173",  
                            "http://127.0.0.1:3000",
                            "http://127.0.0.1:5173",
                            "https://task-project-frontend-fawn.vercel.app/"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
