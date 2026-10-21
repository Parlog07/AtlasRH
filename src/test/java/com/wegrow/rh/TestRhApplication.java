package com.wegrow.rh;

import org.springframework.boot.SpringApplication;

public class TestRhApplication {

    public static void main(String[] args) {
        SpringApplication.from(RhApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
