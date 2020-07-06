package com.hj.pas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasApplication.class, args);
    }

}
