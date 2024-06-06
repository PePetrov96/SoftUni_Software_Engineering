package com.project.spring.config;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {
    @Bean
    public Validator validator(){
        try {
            return Validation
                    .buildDefaultValidatorFactory()
                    .getValidator();
        } catch (Exception e) {
            throw new BeanInitializationException("Failed to initialize Validator bean", e);
        }
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
