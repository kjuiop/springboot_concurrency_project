package com.gig.springboot_concurrency_project.domain;

import com.gig.springboot_concurrency_project.domain.type.ChannelType;
import com.gig.springboot_concurrency_project.domain.type.CouponType;
import com.gig.springboot_concurrency_project.domain.type.ProcessStatus;
import com.gig.springboot_concurrency_project.domain.type.YnType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long id;

    @Column(nullable = false)
    private String couponNo;

    @Column(name = "coupon_name")
    private String name;

    @Builder.Default
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private YnType activeYn = YnType.N;

    @Builder.Default
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private YnType recoveryYn = YnType.N;

    @Builder.Default
    @Column(length = 1)
    @Enumerated(EnumType.STRING)
    private ChannelType channelType = ChannelType.COMMON;

    private String content;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "process_status", length = 20, nullable = false)
    private ProcessStatus status = ProcessStatus.BEFORE;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_type", length = 20, nullable = false)
    private CouponType type;

    private int salePrice;

    private String notice;

    @Column(name = "coupon_image_url", length = 1000)
    private String imageUrl;

    private LocalDateTime publishStartAt;

    private LocalDateTime publishEndAt;

    private LocalDateTime useStartAt;

    private LocalDateTime useEndAt;

    private String createdByUsername;

    private String updatedByUsername;
}
