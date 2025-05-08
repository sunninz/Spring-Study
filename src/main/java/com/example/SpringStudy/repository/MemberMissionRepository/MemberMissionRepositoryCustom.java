package com.example.SpringStudy.repository.MemberMissionRepository;

import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.web.dto.response.MissionHistoryResponseDto;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MissionHistoryResponseDto> findMissionsByMemberIdAndStatus(Long memberId, MissionStatus status);

}
