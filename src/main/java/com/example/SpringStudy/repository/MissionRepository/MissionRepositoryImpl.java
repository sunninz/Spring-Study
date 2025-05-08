package com.example.SpringStudy.repository.MissionRepository;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.QMission;
import com.example.SpringStudy.domain.QRegion;
import com.example.SpringStudy.domain.QStore;
import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.QMemberMission;
import com.example.SpringStudy.web.dto.HomeReponseDto;
import com.example.SpringStudy.web.dto.MyMissionResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QRegion region = QRegion.region;
    private final QStore store = QStore.store;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public HomeReponseDto findHomedataByMemberId(Member member) {
        // memberId의 지역, 포인트 조회
        String regionName = member.getSpecAddress();
        Integer point = member.getPoint();

        // 완료한 미션 Id 조회
        List<Long> challengedMissionIds = jpaQueryFactory
                .select(memberMission.mission.id)
                .from(memberMission)
                .where(memberMission.member.id.eq(member.getId()))
                .fetch();

        // 완료한 미션 수
        int completed = challengedMissionIds.size();

        // my mission(완료하지 않은 미션 id) 조회
        List<MyMissionResponseDto> missions = jpaQueryFactory
                .select(Projections.constructor(
                        MyMissionResponseDto.class,
                        store.name,
                        store.category,
                        mission.missionDescription,
                        mission.reward,
                        mission.deadline
                ))
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(
                region.name.eq(regionName),
                mission.id.notIn(challengedMissionIds.isEmpty() ? List.of(-1L) : challengedMissionIds)
                )
                .fetch();

        return new HomeReponseDto(
                regionName,
                point,
                completed,
                missions
        );
    }
}
