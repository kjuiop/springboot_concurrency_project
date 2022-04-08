package com.gig.springboot_concurrency_project.repository;

import com.gig.springboot_concurrency_project.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Jake
 * @date : 2022-03-16
 */
@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query(value = "SELECT * FROM COUPON c ORDER BY c.CREATED_AT ASC LIMIT 1", nativeQuery = true)
    Optional<Coupon> getFirstCoupon();
}
