package com.gig.springboot_concurrency_project.repository;

import com.gig.springboot_concurrency_project.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Jake
 * @date : 2022-03-16
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT * FROM MEMBER ORDER BY CREATED_AT ASC limit 1", nativeQuery = true)
    Optional<Member> getFirstMember();
}
