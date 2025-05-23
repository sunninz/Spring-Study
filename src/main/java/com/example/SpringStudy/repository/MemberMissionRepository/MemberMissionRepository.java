package com.example.SpringStudy.repository.MemberMissionRepository;

import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom{

    // memberId 삭제
    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM MemberMission mp WHERE mp.member.id = :memberId")
    void deleteByMemberId(@Param("memberId") Long memberId);

    // 중복 도전 여부 확인
    boolean existsByMemberIdAndMissionIdAndStatusIn(Long memberId, Long missionId, List<MissionStatus> statusList);

}