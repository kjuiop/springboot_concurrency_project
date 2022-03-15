package com.gig.springboot_concurrency_project.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Getter
@RequiredArgsConstructor
public enum ProcessStatus {

    BEFORE("before", "예정"),
    IN_PROGRESS("inProgress", "진행"),
    COMPLETE("complete", "종료");

    private final String key;

    private final String description;
}
