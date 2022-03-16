package com.gig.springboot_concurrency_project.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Getter
@RequiredArgsConstructor
public enum SaleType {

    PRICE("price", "정액"),
    RATE("rate", "정률");

    private final String key;

    private final String description;

}
