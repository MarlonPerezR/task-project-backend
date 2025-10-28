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
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        // Lista explícita de orígenes permitidos
                        .allowedOrigins(
                                "https://task-project-frontend-fawn.vercel.app",
                                "http://localhost:3000"
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
                        .allowedHeaders("*")
                        .exposedHeaders("Authorization", "Content-Type", "Content-Disposition")
                        // Desactiva credenciales si no usas cookies o auth
                        .allowCredentials(false)
                        .maxAge(3600);
            }
        };
    }
}
