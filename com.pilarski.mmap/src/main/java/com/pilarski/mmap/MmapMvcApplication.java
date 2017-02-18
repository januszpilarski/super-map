package com.pilarski.mmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication
public class MmapMvcApplication extends org.springframework.boot.web.support.SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MmapMvcApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MmapMvcApplication.class, args);
    }
}