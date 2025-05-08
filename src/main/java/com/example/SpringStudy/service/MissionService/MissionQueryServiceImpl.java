package com.example.SpringStudy.service.MissionService;

import com.example.SpringStudy.repository.MissionRepository.MissionRepository;
import com.example.SpringStudy.web.dto.MyMissionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;

    // 홈 - 미션 조회 로직
    @Override
    public List<MyMissionResponseDto> getMyMissionByReagionName(String regionName) {
        return missionRepository.findMissionsByRegionName(regionName);
    }
}
