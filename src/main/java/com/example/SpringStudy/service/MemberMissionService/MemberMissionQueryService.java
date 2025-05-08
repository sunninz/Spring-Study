package com.example.SpringStudy.service.MemberMissionService;

import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.web.dto.response.MissionHistoryResponseDto;

import java.util.List;

public interface MemberMissionQueryService {
    List<MissionHistoryResponseDto> getMissionHistory(Long memberId, MissionStatus status);
}
