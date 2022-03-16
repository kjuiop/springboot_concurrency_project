package com.gig.springboot_concurrency_project.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Getter
@RequiredArgsConstructor
public enum PeriodType {

    UNLimit("unLimit", "무제한"),
    LIMIT("limit", "기간한정");

    private final String key;

    private final String description;

}
