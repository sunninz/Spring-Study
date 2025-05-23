package com.example.SpringStudy.service.MemberMissionService;

import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.web.dto.request.MemberMissionRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    MemberMission createChallenge(MemberMissionRequestDTO.ChallengeDTO request);
}
