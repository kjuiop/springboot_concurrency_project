package com.gig.springboot_concurrency_project.repository;

import com.gig.springboot_concurrency_project.domain.Coupon;
import com.gig.springboot_concurrency_project.domain.Member;
import com.gig.springboot_concurrency_project.domain.MemberCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author : Jake
 * @date : 2022-04-08
 */
@Repository
public interface MemberCouponRepository extends JpaRepository<MemberCoupon, Long> {

    List<MemberCoupon> findByMemberAndCoupon(Member member, Coupon coupon);
}
