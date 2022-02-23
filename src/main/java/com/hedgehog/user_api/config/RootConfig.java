package com.hedgehog.user_api.config;

import com.hedgehog.user_api.service.IUserService;
import com.hedgehog.user_api.service.UserService;
import com.hedgehog.user_api.storage.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.hedgehog.user_api.config")
public class RootConfig {

    @Bean
    public IUserService userView(IUserRepository userRepository){
        return new UserService(userRepository);
    }



}
