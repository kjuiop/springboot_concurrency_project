package com.gig.springboot_concurrency_project.service;

import com.gig.springboot_concurrency_project.dto.CouponCreateForm;
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

    @Transactional
    public String createByAdmin(CouponCreateForm createForm) {
        return null;
    }


}
