package com.gig.springboot_concurrency_project.controller;

import com.gig.springboot_concurrency_project.dto.CouponCreateForm;
import com.gig.springboot_concurrency_project.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jake
 * @date : 2022-03-30
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CouponRestController {

    private final CouponService couponService;

    @PostMapping("/coupon")
    public ResponseEntity createCoupon(@RequestBody @Validated CouponCreateForm createForm
                                        , Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }

        String couponNo = couponService.create(createForm);

        return ResponseEntity.ok().body(couponNo);
    }

}
