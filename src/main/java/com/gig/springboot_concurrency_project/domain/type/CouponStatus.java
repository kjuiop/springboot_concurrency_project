package com.gig.springboot_concurrency_project.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Getter
@RequiredArgsConstructor
public enum CouponStatus {

    UNUSED("unUsed", "미사용"),
    USED("used", "사용"),
    EXPIRED("expired", "만료"),
    RETRIEVE("retrieve", "회수"),
    RECOVERY("recovery", "복원");

    private final String key;

    private final String description;

}
