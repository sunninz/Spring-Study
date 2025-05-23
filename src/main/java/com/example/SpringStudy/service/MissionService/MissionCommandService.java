package com.example.SpringStudy.service.MissionService;

import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.web.dto.request.MissionRequestDTO;

public interface MissionCommandService {
    // 가기에 미션 추가
    Mission createMission(MissionRequestDTO.CreateMissionDTO request);

    // 가게 확인
    boolean storeExist(Long id);

    // 미션 검증
    boolean missionExist(Long id);
}
