package com.example.SpringStudy.converter;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.web.dto.response.MemberMissionResponseDTO;
import com.example.SpringStudy.web.dto.response.MissionResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MemberMissionConverter {

    public static MemberMissionResponseDTO.CreateChallengeResultDTO toCreateChallengeResultDTO(MemberMission memberMission){
        return MemberMissionResponseDTO.CreateChallengeResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(Member member, Mission mission){
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
