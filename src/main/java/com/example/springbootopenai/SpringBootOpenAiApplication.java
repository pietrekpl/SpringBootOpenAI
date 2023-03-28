package com.example.springbootopenai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootOpenAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOpenAiApplication.class, args);
    }

}
