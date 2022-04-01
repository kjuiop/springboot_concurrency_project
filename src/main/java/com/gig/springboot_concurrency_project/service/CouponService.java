package com.gig.springboot_concurrency_project.service;

import com.gig.springboot_concurrency_project.domain.Coupon;
import com.gig.springboot_concurrency_project.dto.CouponCreateForm;
import com.gig.springboot_concurrency_project.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Jake
 * @date : 2022-03-30
 */
@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public String create(CouponCreateForm form) {

        Coupon newCoupon = Coupon.create(form);

        couponRepository.save(newCoupon);

        return newCoupon.getCouponNo();
    }


}
