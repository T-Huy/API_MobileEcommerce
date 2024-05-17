package com.ecomerce.android.config;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
        return mapper;
    }
    @Bean
    public Cloudinary cloudinary() {
        Map config = new HashMap();
        config.put("cloud_name", "diuvcc3pl");
        config.put("api_key", "575575684348628");
        config.put("api_secret", "b5OJWsgfU6bvlZx1EGp95kj5R5E");
        Cloudinary cloudinary = new Cloudinary(config);
        return cloudinary;
    }
}
