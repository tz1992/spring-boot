package com.fiberhome.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@MapperScan("com.fiberhome.practice.dao")
@SpringBootApplication
public class MainApplication {
public static void main(String[] args) {
	SpringApplication.run(MainApplication.class, args);
}
}
