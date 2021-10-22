package com.fiberhome.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

@MapperScan("com.fiberhome.practice.dao")
@SpringBootApplication
public class MainApplication {
public static void main(String[] args)  {
	SpringApplication.run(MainApplication.class, args);
	String str="admin123";
	String real=DigestUtils.md5DigestAsHex(str.getBytes());
	System.out.println(real);

}
}
