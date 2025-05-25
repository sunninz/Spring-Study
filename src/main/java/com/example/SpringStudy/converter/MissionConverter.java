package com.example.SpringStudy.converter;

import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.domain.Store;
import com.example.SpringStudy.web.dto.request.MissionRequestDTO;
import com.example.SpringStudy.web.dto.response.MissionResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MissionConverter {
    public static MissionResponseDTO.CreateResultDTO toCreateResultDTO(Mission mission){
        return MissionResponseDTO.CreateResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();

    }

    public static Mission toMission(MissionRequestDTO.CreateMissionDTO request, Store store){
        return Mission.builder()
                .missionDescription(request.getMissionDescription())
                .deadline(request.getDeadline())
                .reward(request.getReward())
                .store(store)
                .build();

    }

    public static MissionResponseDTO.MissionInfoDTO missionInfoDTO(Mission mission){
        return MissionResponseDTO.MissionInfoDTO.builder()
                .missionDescription(mission.getMissionDescription())
                .deadline(mission.getDeadline())
                .reward(mission.getReward())
                .build();
    }

    public static MissionResponseDTO.MissionInfoListDTO missionInfoListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionInfoDTO> missionInfoDTOList = missionList.stream()
                .map(MissionConverter::missionInfoDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionInfoListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionInfoDTOList.size())
                .missionInfoDTOList(missionInfoDTOList)
                .build();
    }

}