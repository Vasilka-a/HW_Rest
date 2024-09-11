package org.example.rest_task.config;

import org.example.rest_task.controller.AuthorizationController;
import org.example.rest_task.model.UserHandlerMethodArgumentResolver;
import org.example.rest_task.repository.UserRepository;
import org.example.rest_task.service.AuthorizationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class JavaConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UserHandlerMethodArgumentResolver());
    }

    @Bean
    public AuthorizationController authorizationController(AuthorizationService service) {
        return new AuthorizationController(service);
    }


    @Bean
    public AuthorizationService authorizationService(UserRepository repository) {
        return new AuthorizationService(repository);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}