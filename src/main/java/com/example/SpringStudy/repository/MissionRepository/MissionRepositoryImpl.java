package com.example.SpringStudy.repository.MissionRepository;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.QMission;
import com.example.SpringStudy.domain.QRegion;
import com.example.SpringStudy.domain.QStore;
import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.QMemberMission;
import com.example.SpringStudy.web.dto.response.HomeReponseDto;
import com.example.SpringStudy.web.dto.response.MyMissionResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

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

        // 1. 완료한 미션 ID만 필터링
        Long completed = jpaQueryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(
                        memberMission.member.id.eq(member.getId()),
                        memberMission.status.eq(MissionStatus.COMPLETE)
                )
                .fetchOne();

        // 2. 진행중/진행완료된 미션id
        List<Long> participatedMissionIds = jpaQueryFactory
                .select(memberMission.mission.id)
                .from(memberMission)
                .where(memberMission.member.id.eq(member.getId()))
                .fetch();

        // 3. My Mission
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
                        mission.id.notIn(participatedMissionIds.isEmpty() ? List.of(-1L) : participatedMissionIds)
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
