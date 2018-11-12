package com.dxs.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ApiApplication extends SpringBootServletInitializer
{
    public static void main(String[] args)
    {
        SpringApplication.run(ApiApplication.class, new String[0]);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
    {
        return builder.sources(new Class[] { ApiApplication.class });
    }
}