package com.gig.springboot_concurrency_project.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Getter
@RequiredArgsConstructor
public enum CouponType {

    PRODUCT("product", "상품"),
    ORDER("order", "주문"),
    DELIVERY_FEE("deliveryFee", "배송비");

    private final String key;

    private final String description;

}
