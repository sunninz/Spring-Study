package com.example.SpringStudy.repository.MissionRepository;

import com.example.SpringStudy.web.dto.MyMissionResponseDto;

import java.util.List;

public interface MissionRepositoryCustom {
    List<MyMissionResponseDto> findMissionsByRegionName(String regionName);

}
