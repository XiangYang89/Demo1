package org.example;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.mapper")
public class JsoupDemoDay3App {
    public static void main(String[] args){
        SpringApplication.run(JsoupDemoDay3App.class,args);
    }
}
