package com.gig.springboot_concurrency_project.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Getter
@RequiredArgsConstructor
public enum CouponDiscountTarget {

    ALL("all", "전체"),
    CATEGORY("category", "카테고리"),
    BRAND("brand", "브랜드"),
    PARTNER("partner", "입점사"),
    PRODUCT("product", "상품");

    private final String key;

    private final String description;

}
