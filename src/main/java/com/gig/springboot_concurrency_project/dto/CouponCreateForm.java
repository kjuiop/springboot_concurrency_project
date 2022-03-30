package com.gig.springboot_concurrency_project.dto;

import com.gig.springboot_concurrency_project.domain.type.CouponDiscountTarget;
import com.gig.springboot_concurrency_project.domain.type.CouponType;
import com.gig.springboot_concurrency_project.domain.type.SaleType;
import com.gig.springboot_concurrency_project.domain.type.YnType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author : Jake
 * @date : 2022-03-30
 */
@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CouponCreateForm {

    private String name;

    private CouponType couponType;

    private SaleType saleType;

    private CouponDiscountTarget discountTarget;

    private int salePrice;

    private int saleRate;

    private LocalDateTime publishStartAt;

    private LocalDateTime publishEndAt;

    private LocalDateTime useStartAt;

    private LocalDateTime useEndAt;

}
