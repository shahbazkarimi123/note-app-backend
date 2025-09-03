package com.karimi.note_app_backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class NoteWebConfiguration implements WebMvcConfigurer{
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/api/notes/**")
        .allowedOrigins("https://note-app-kappa-flax.vercel.app")

        .allowedMethods("GET","POST","PUT","DELETE");
    }
    
}
