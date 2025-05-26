package com.example.SpringStudy.converter;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.Store;
import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.web.dto.response.MemberMissionResponseDTO;
import com.example.SpringStudy.web.dto.response.MissionResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MemberMissionResponseDTO.MissionInfoDTO missionInfoDTO(Mission mission, Store store){
        return MemberMissionResponseDTO.MissionInfoDTO.builder()
                .storeName(store.getName())
                .missionDescription(mission.getMissionDescription())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static MemberMissionResponseDTO.MissionInfoListDTO missionInfoListDTO(Page<MemberMission> memberMissionList){
        List<MemberMissionResponseDTO.MissionInfoDTO> missionInfoDTOList = memberMissionList.stream()
                .map(mm -> MemberMissionConverter.missionInfoDTO(mm.getMission(), mm.getMission().getStore()))
                .collect(Collectors.toList());

        return MemberMissionResponseDTO.MissionInfoListDTO.builder()
                .missionInfoDTOList(missionInfoDTOList)
                .listSize(missionInfoDTOList.size())
                .totalPage(memberMissionList.getTotalPages())
                .totalElements(memberMissionList.getTotalElements())
                .isFirst(memberMissionList.isFirst())
                .isLast(memberMissionList.isLast())
                .build();
    }
}
