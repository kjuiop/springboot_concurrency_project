package com.gig.springboot_concurrency_project.domain;

import com.gig.springboot_concurrency_project.domain.type.UserStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@Entity
@SuperBuilder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    private String username;

    private String password;

    @Builder.Default
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.PENDING;

    @Builder.Default
    @Column(columnDefinition = "integer default 0")
    private Integer passwordFailureCount = 0;

    private LocalDateTime lastLoginAt;

    private LocalDateTime withDrawAt;

}
