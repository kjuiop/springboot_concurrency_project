package com.gig.springboot_concurrency_project.util;

import com.gig.springboot_concurrency_project.exception.AlreadyEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Component
public class InitUtils {

    @Transactional(rollbackFor = {AlreadyEntity.class})
    public void initData() {

    }
}
