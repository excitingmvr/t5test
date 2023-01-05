package com.example.t5test.web.xdm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.t5test.web.xdm","com.example.t5test.core"})
public class T5testWebXdmApplication {

    public static void main(String[] args) {
        SpringApplication.run(T5testWebXdmApplication.class, args);
    }

}
