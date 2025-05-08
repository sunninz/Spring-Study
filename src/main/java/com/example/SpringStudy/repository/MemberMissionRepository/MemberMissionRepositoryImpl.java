package com.example.SpringStudy.repository.MemberMissionRepository;

import com.example.SpringStudy.domain.QMission;
import com.example.SpringStudy.domain.QStore;
import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.QMemberMission;
import com.example.SpringStudy.web.dto.response.MissionHistoryResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;

    @Override
    public List<MissionHistoryResponseDto> findMissionsByMemberIdAndStatus(Long memberId, MissionStatus status) {
        return jpaQueryFactory
                .select(Projections.constructor(
                        MissionHistoryResponseDto.class,
                        store.name,
                        mission.missionDescription,
                        mission.reward
                ))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .join(mission.store, store)
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(status)
                )
                .fetch();
    }
}
