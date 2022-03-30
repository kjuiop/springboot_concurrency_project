package com.gig.springboot_concurrency_project.dto;

import com.gig.springboot_concurrency_project.domain.Coupon;
import com.gig.springboot_concurrency_project.domain.type.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author : Jake
 * @date : 2022-03-30
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CouponDto {

    private String couponNo;

    private String name;

    private YnType activeYn;

    private YnType recoveryYn;

    private ChannelType channelType;

    private ProcessStatus status;

    private CouponType couponType;

    private SaleType saleType;

    private CouponDiscountTarget discountTarget;

    private int salePrice;

    private int saleRate;

    private String useCondition;

    private int sharePartnerRate;

    private String imageUrl;

    private Long brandId;

    private Long categoryId;

    private Long partnerId;

    private Long productId;

    private LocalDateTime useStartAt;

    private LocalDateTime useEndAt;

    public CouponDto(Coupon coupon) {
        this.couponNo = coupon.getCouponNo();
        this.name = coupon.getName();
        this.activeYn = coupon.getActiveYn();
        this.recoveryYn = coupon.getRecoveryYn();
        this.channelType = coupon.getChannelType();
        this.status = coupon.getStatus();
        this.couponType = coupon.getCouponType();
        this.saleType = coupon.getSaleType();
        this.discountTarget = coupon.getDiscountTarget();
        this.salePrice = coupon.getSalePrice();
        this.saleRate = coupon.getSaleRate();
        this.useCondition = coupon.getUseCondition();
        this.sharePartnerRate = coupon.getSharePartnerRate();
        this.imageUrl = coupon.getImageUrl();
        this.brandId = coupon.getBrandId();
        this.categoryId = coupon.getCategoryId();
        this.partnerId = coupon.getPartnerId();
        this.productId = coupon.getProductId();
        this.useStartAt = coupon.getUseEndAt();
    }
}
