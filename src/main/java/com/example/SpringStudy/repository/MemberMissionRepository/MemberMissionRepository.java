package com.example.SpringStudy.repository.MemberMissionRepository;

import com.example.SpringStudy.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>{

    // memberId 삭제
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM MemberMission mp WHERE mp.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);
}