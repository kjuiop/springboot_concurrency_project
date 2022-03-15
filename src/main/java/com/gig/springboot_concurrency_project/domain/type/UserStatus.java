package com.gig.springboot_concurrency_project.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Getter
@RequiredArgsConstructor
public enum UserStatus {

    PENDING("Pending", "보류"),

    NORMAL("Normal", "정상"),

    WITHDRAW("Withdraw", "탈퇴"),

    INACTIVE("InActive", "비활성화");

    private final String key;

    private final String description;

}
