package dev.cbq;

import org.springframework.boot.SpringApplication;

public class TestBackendTemplateSpringBoot3Application {

    public static void main(String[] args) {
        SpringApplication.from(BackendApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
