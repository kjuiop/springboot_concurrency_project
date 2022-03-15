package com.gig.springboot_concurrency_project.domain.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Getter
@RequiredArgsConstructor
public enum ChannelType {

    COMMON("common", "공통"),
    PC("pc", "PC"),
    MOBILE("mobile", "Mobile Web"),
    APP("app", "APP");

    private final String key;

    private final String description;

}
