package com.gig.springboot_concurrency_project.repository;

import com.gig.springboot_concurrency_project.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Jake
 * @date : 2022-03-16
 */
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
