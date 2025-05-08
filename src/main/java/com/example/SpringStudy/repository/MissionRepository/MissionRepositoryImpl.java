package com.example.SpringStudy.repository.MissionRepository;

import com.example.SpringStudy.domain.QMission;
import com.example.SpringStudy.domain.QRegion;
import com.example.SpringStudy.domain.QStore;
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


    @Override
    public List<MyMissionResponseDto> findMissionsByRegionName(String regionName) {
        return jpaQueryFactory
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
                .where(region.name.eq(regionName))
                .fetch();
    }
}
