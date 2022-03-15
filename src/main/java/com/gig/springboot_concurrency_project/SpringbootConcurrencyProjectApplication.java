package com.gig.springboot_concurrency_project;

import com.gig.springboot_concurrency_project.util.InitUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringbootConcurrencyProjectApplication {

    private static InitUtils initUtils;

    public static void main(String[] args) {
        initUtils.initData();
        SpringApplication.run(SpringbootConcurrencyProjectApplication.class, args);
    }

}
