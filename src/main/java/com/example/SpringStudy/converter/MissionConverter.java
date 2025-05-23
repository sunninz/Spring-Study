package com.example.SpringStudy.converter;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.Store;
import com.example.SpringStudy.domain.enums.Gender;
import com.example.SpringStudy.web.dto.request.MemberRequestDTO;
import com.example.SpringStudy.web.dto.request.MissionRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberResponseDTO;
import com.example.SpringStudy.web.dto.response.MissionResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
}