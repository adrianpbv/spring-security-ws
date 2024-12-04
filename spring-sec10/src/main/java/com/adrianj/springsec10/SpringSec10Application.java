package com.adrianj.springsec10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableWebSecurity(debug = true)// TODO note 2 delete on production
public class SpringSec10Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSec10Application.class, args);
    }

}
