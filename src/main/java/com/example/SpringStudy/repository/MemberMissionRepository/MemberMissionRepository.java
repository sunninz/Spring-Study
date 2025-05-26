package com.example.SpringStudy.repository.MemberMissionRepository;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    // 완료된 미션 여부 확인
    @Query("""
    SELECT COUNT(m) > 0
    FROM MemberMission m
    JOIN m.mission mi
    WHERE m.member.id = :memberId
      AND mi.store.id = :storeId
      AND m.status = 'COMPLETE'
    """)
    boolean existsCompletedMissionByMemberAndStore(@Param("memberId") Long memberId, @Param("storeId") Long storeId);

    Page<MemberMission> findAllByMemberAndStatus(Member member, MissionStatus status, PageRequest pageRequest);

}