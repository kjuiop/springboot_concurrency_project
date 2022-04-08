package com.gig.springboot_concurrency_project.domain;

import com.gig.springboot_concurrency_project.domain.type.CouponStatus;
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
    @Column(name = "member_coupon_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_status", length = 20, nullable = false)
    private CouponStatus status = CouponStatus.UNUSED;

    private LocalDateTime useStartAt;

    private LocalDateTime useEndAt;

    private String givenReason;

    private LocalDateTime givenAt;

    private String withdrawReason;

    private LocalDateTime withdrawAt;

    private LocalDateTime downloadAt;

    private LocalDateTime recoveryAt;

    public static MemberCoupon download(Member member, Coupon coupon) {
        return MemberCoupon.builder()
                .member(member)
                .coupon(coupon)
                .downloadAt(LocalDateTime.now())
                .build();
    }

}
