package com.example.SpringStudy.service.MemberMissionService;

import com.example.SpringStudy.converter.MemberMissionConverter;
import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.repository.MemberMissionRepository.MemberMissionRepository;
import com.example.SpringStudy.repository.MemberRepository.MemberRepository;
import com.example.SpringStudy.repository.MissionRepository.MissionRepository;
import com.example.SpringStudy.web.dto.request.MemberMissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService{

    private final MemberMissionRepository memberMissionRepository;
    private final MemberMissionConverter memberMissionConverter;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    public MemberMission createChallenge(MemberMissionRequestDTO.ChallengeDTO request) {
        Long memberId = request.getMemberId();
        Long missionId = request.getMissionId();

        Member member = memberRepository.findById(memberId)
                .orElseThrow();

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow();

        MemberMission memberMission = MemberMissionConverter.toMemberMission(member, mission);
        return memberMissionRepository.save(memberMission);
    }
}
