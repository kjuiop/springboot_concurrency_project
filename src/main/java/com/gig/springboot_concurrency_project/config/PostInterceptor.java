package com.gig.springboot_concurrency_project.config;

import com.gig.springboot_concurrency_project.util.InitUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author : Jake
 * @date : 2022-03-16
 */
@Component
@RequiredArgsConstructor
public class PostInterceptor {

    private final InitUtils initUtils;

    @PostConstruct
    public void initData() {
        initUtils.initData();
    }
}
