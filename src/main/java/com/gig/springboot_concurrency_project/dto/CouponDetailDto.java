package com.gig.springboot_concurrency_project.dto;

import com.gig.springboot_concurrency_project.domain.type.YnType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author : Jake
 * @date : 2022-03-30
 */
@Getter
@NoArgsConstructor
public class CouponDetailDto extends CouponDto {


    private String content;

    private YnType publishQtyLimitYn;

    private int maxPublishQty;

    private YnType downloadQtyLimitYn;

    private int maxDownloadQty;

    private int useWithinDay;

    private LocalDateTime publishStartAt;

    private LocalDateTime publishEndAt;

    private String createdByName;

    private String updatedByName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
