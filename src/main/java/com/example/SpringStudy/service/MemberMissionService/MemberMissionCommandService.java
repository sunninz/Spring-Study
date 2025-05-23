package com.example.SpringStudy.service.MemberMissionService;

import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.web.dto.request.MemberMissionRequestDTO;
import com.example.SpringStudy.web.dto.request.ReviewRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberMissionResponseDTO;

public interface MemberMissionCommandService {
    // 미션 등록
    MemberMission createChallenge(MemberMissionRequestDTO.ChallengeDTO request);
    // 미션 등록 검증
    boolean challengeExist(MemberMissionRequestDTO.ChallengeDTO request);
    // 완료된 미션 검증
    boolean completedMission(ReviewRequestDTO.CreateDTO dto);
}
