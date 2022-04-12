package com.gig.springboot_concurrency_project.service;

import com.gig.springboot_concurrency_project.domain.Coupon;
import com.gig.springboot_concurrency_project.domain.Member;
import com.gig.springboot_concurrency_project.domain.MemberCoupon;
import com.gig.springboot_concurrency_project.dto.CouponCreateForm;
import com.gig.springboot_concurrency_project.dto.MemberCouponDto;
import com.gig.springboot_concurrency_project.exception.NotFoundException;
import com.gig.springboot_concurrency_project.repository.CouponRepository;
import com.gig.springboot_concurrency_project.repository.MemberCouponRepository;
import com.gig.springboot_concurrency_project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Jake
 * @date : 2022-03-30
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final MemberRepository memberRepository;
    private final MemberCouponRepository memberCouponRepository;

    @Transactional
    public String create(CouponCreateForm form) {

        Coupon newCoupon = Coupon.create(form);

        couponRepository.save(newCoupon);

        return newCoupon.getCouponNo();
    }


    @Transactional
    public void couponDownload() {

        Member initMember = memberRepository.getFirstMember().orElseThrow(() -> new NotFoundException("not exist member"));
        Coupon initCoupon = couponRepository.getFirstCoupon().orElseThrow(() -> new NotFoundException("not exist coupon"));

        int maxDownloadQty = initCoupon.getMaxDownloadQty();

        List<MemberCoupon> memberCoupons = memberCouponRepository.findByMemberAndCoupon(initMember, initCoupon);

        String threadName = Thread.currentThread().getName();
        log.info("{} / coupon size = {}", threadName, memberCoupons.size());

        if (memberCoupons.size() < maxDownloadQty) {
            MemberCoupon newMemberCoupon = MemberCoupon.download(initMember, initCoupon);
            memberCouponRepository.save(newMemberCoupon);
        }
    }

    public List<MemberCouponDto> getInitMemberCoupon() {
        Member initMember = memberRepository.getFirstMember().orElseThrow(() -> new NotFoundException("not exist member"));
        Coupon initCoupon = couponRepository.getFirstCoupon().orElseThrow(() -> new NotFoundException("not exist coupon"));

        List<MemberCoupon> memberCoupons = memberCouponRepository.findByMemberAndCoupon(initMember, initCoupon);

        return memberCoupons.stream().map(MemberCouponDto::new).collect(Collectors.toList());
    }


}
