package com.gig.springboot_concurrency_project.util;

import com.gig.springboot_concurrency_project.domain.Coupon;
import com.gig.springboot_concurrency_project.exception.AlreadyEntity;
import com.gig.springboot_concurrency_project.repository.CouponRepository;
import com.gig.springboot_concurrency_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

        Coupon coupon = new Coupon();

    }

}
