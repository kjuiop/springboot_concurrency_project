package com.gig.springboot_concurrency_project.service;

import com.gig.springboot_concurrency_project.dto.MemberCouponDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Jake
 * @date : 2022-04-08
 */
@SpringBootTest
@RequiredArgsConstructor
public class CouponServiceTest {

    @Autowired
    private CouponService couponService;

    @Test
    @DisplayName("쿠폰다운로드테스트")
    public void couponDownloadTest() {
        couponService.couponDownload();
    }

    @Test
    @DisplayName("쿠폰다운로드 동시성 테스트")
    public void couponDownloadConcurrencyTest() {

        try {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            CountDownLatch latch = new CountDownLatch(5);
            for (int i = 0; i < 5; i++) {
                executorService.execute(() -> {
                    String name = Thread.currentThread().getName();
                    System.out.println("current thread name = " + name);

                    couponService.couponDownload();
                });
                latch.countDown();
            }

            latch.await();

            List<MemberCouponDto> memberCoupons = couponService.getInitMemberCoupon();
            assertEquals(memberCoupons.size(), 3);
        } catch (RuntimeException | InterruptedException re) {
            re.printStackTrace();
        }
    }
}
