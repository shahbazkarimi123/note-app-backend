package com.karimi.note_app_backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class NoteWebConfiguration implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/notes/**")
        .allowedOrigins("http://localhost:5173","http://192.168.1.26:5173")

        .allowedMethods("GET","POST","PUT","DELETE");
    }
    
}
