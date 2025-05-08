package com.example.SpringStudy.service.MemberMissionService;

import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.repository.MemberMissionRepository.MemberMissionRepository;
import com.example.SpringStudy.web.dto.response.MissionHistoryResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService{

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<MissionHistoryResponseDto> getMissionHistory(Long memberId, MissionStatus status) {
        return memberMissionRepository.findMissionsByMemberIdAndStatus(memberId,status);
    }
}
