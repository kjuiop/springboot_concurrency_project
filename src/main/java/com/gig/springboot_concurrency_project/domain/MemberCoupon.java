package com.gig.springboot_concurrency_project.domain;

import com.gig.springboot_concurrency_project.domain.type.CouponStatus;
import com.gig.springboot_concurrency_project.domain.type.ProcessStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Entity
@SuperBuilder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberCoupon extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_member_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_status", length = 20, nullable = false)
    private CouponStatus status;

    private LocalDateTime useStartAt;

    private LocalDateTime useEndAt;

    private String givenReason;

    private LocalDateTime givenAt;

    private String withdrawReason;

    private LocalDateTime withdrawAt;

    private LocalDateTime downloadAt;

    private LocalDateTime recoveryAt;

}
