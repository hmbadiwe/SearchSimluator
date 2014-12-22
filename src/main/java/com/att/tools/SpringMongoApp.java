package com.att.tools;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class SpringMongoApp
{
    public static void main(String[] args){
        SpringApplication.run(SpringMongoApp.class, args);

    }
}
