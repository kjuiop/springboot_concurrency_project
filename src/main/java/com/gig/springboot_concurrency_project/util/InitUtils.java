package com.gig.springboot_concurrency_project.util;

import com.gig.springboot_concurrency_project.domain.Coupon;
import com.gig.springboot_concurrency_project.domain.Member;
import com.gig.springboot_concurrency_project.domain.type.ChannelType;
import com.gig.springboot_concurrency_project.domain.type.CouponType;
import com.gig.springboot_concurrency_project.domain.type.SaleType;
import com.gig.springboot_concurrency_project.domain.type.YnType;
import com.gig.springboot_concurrency_project.repository.CouponRepository;
import com.gig.springboot_concurrency_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Component
@RequiredArgsConstructor
public class InitUtils {

    private final CouponRepository couponRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void initData() {
        if (couponRepository.count() > 0 || memberRepository.count() > 0) {
            return;
        }

        Coupon coupon = Coupon.init();
        couponRepository.save(coupon);

        Member member = Member.init();
        memberRepository.save(member);
    }

}
