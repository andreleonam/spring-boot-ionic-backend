package com.educandoweb.cursomc2022.config;

import com.educandoweb.cursomc2022.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDatabase() {
        dbService.instantiateTestDatabase();
        return true;
    }
}
