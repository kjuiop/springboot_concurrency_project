package com.gig.springboot_concurrency_project.domain;

import com.gig.springboot_concurrency_project.domain.BaseEntity;
import com.gig.springboot_concurrency_project.domain.type.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Entity
@Getter
@SuperBuilder
@NoArgsConstructor @AllArgsConstructor
public class Coupon extends BaseEntity {

    @Id
    @GenericGenerator(name = "coupon_no", strategy = "com.gig.springboot_concurrency_project.domain.generator.CouponNoGenerator")
    @GeneratedValue(generator = "coupon_no")
    private String couponNo;

    @Column(name = "coupon_name")
    private String name;

    private String content;

    @Builder.Default
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private YnType activeYn = YnType.N;

    @Builder.Default
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private YnType recoveryYn = YnType.N;

    @Builder.Default
    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private ChannelType channelType = ChannelType.COMMON;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "process_status", length = 20, nullable = false)
    private ProcessStatus status = ProcessStatus.BEFORE;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CouponType couponType;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private SaleType saleType;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CouponDiscountTarget discountTarget;

    private int salePrice;

    private int saleRate;

    private String useCondition;

    private int sharePartnerRate;

    @Column(name = "coupon_image_url", length = 1000)
    private String imageUrl;

    private Long brandId;

    private Long categoryId;

    private Long partnerId;

    private Long productId;

    @Builder.Default
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private YnType publishQtyLimitYn = YnType.N;

    private int maxPublishQty;

    @Builder.Default
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private YnType downloadQtyLimitYn = YnType.N;

    private int maxDownloadQty;

    private int useWithinDay;

    private LocalDateTime publishStartAt;

    private LocalDateTime publishEndAt;

    private LocalDateTime useStartAt;

    private LocalDateTime useEndAt;

    private String createdByName;

    private String updatedByName;

    public static Coupon init() {
        return Coupon.builder()
                .name("회원가입 축하 할인 쿠폰")
                .content("회원가입 축하쿠폰")
                .couponType(CouponType.PRODUCT)
                .saleType(SaleType.PRICE)
                .salePrice(200000)
                .discountTarget(CouponDiscountTarget.PRODUCT)
                .downloadQtyLimitYn(YnType.Y)
                .maxDownloadQty(1)
                .useWithinDay(7)
                .publishStartAt(LocalDateTime.now())
                .createdByName("관리자")
                .updatedByName("관리자")
                .build();
    }
}
