package com.gig.springboot_concurrency_project.dto;

import com.gig.springboot_concurrency_project.domain.MemberCoupon;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : Jake
 * @date : 2022-04-08
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberCouponDto {

    private Long memberCouponId;

    private String username;

    private String couponNo;

    public MemberCouponDto(MemberCoupon mc) {
        this.memberCouponId = mc.getId();
        this.username = mc.getMember().getUsername();
        this.couponNo = mc.getCoupon().getCouponNo();
    }
}
