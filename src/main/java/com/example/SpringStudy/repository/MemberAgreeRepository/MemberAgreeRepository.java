package com.example.SpringStudy.repository.MemberAgreeRepository;

import com.example.SpringStudy.domain.mapping.MemberAgree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberAgreeRepository extends JpaRepository<MemberAgree, Long>{
    // memberId 삭제
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM MemberAgree mp WHERE mp.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);
}