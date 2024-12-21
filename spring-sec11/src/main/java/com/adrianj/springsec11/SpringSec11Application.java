package com.adrianj.springsec11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableWebSecurity(debug = true)// delete on production
public class SpringSec11Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSec11Application.class, args);
    }

}
