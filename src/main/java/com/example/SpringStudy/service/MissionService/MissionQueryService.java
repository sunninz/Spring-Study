package com.example.SpringStudy.service.MissionService;

import com.example.SpringStudy.web.dto.MyMissionResponseDto;

import java.util.List;

public interface MissionQueryService {
    List<MyMissionResponseDto> getMyMissionByReagionName(String regionName);
}
