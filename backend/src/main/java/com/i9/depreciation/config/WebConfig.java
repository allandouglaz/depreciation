package com.i9.depreciation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitindo requisições do frontend React

        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Permite a origem do frontend
                .allowedMethods("GET", "POST")
                .allowedHeaders("*");
    }
}
