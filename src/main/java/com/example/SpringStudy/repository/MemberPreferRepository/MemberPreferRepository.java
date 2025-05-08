package com.example.SpringStudy.repository.MemberPreferRepository;

import com.example.SpringStudy.domain.mapping.MemberPrefer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberPreferRepository extends JpaRepository<MemberPrefer, Long> {

    // memberId 삭제
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM MemberPrefer mp WHERE mp.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);
}
