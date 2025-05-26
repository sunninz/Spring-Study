package com.example.SpringStudy.service.MemberMissionService;

import com.example.SpringStudy.converter.MemberMissionConverter;
import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.repository.MemberMissionRepository.MemberMissionRepository;
import com.example.SpringStudy.repository.MemberRepository.MemberRepository;
import com.example.SpringStudy.repository.MissionRepository.MissionRepository;
import com.example.SpringStudy.web.dto.request.MemberMissionRequestDTO;
import com.example.SpringStudy.web.dto.request.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public boolean challengeExist(MemberMissionRequestDTO.ChallengeDTO request) {
        Long memberId = request.getMemberId();
        Long missionId = request.getMissionId();
        return memberMissionRepository.existsByMemberIdAndMissionIdAndStatusIn(
                memberId,
                missionId,
                List.of(MissionStatus.CHALLENGING, MissionStatus.COMPLETE)
        );
    }

    @Override
    public boolean completedMission(ReviewRequestDTO.CreateDTO request) {
        Long memberId = request.getMemberId();
        Long storeId = request.getStoreId();
        return memberMissionRepository.existsCompletedMissionByMemberAndStore(memberId, storeId);
    }

    // 내가 진행중인 미션 목록 조회
    @Override
    public Page<MemberMission> getMissionsByMemberAndStatus(Long memberId, Integer page, MissionStatus status) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow();

        Page<MemberMission> memberMissionPage = memberMissionRepository.findAllByMemberAndStatus(member, status,PageRequest.of(page-1,10));
        return memberMissionPage;
    }
}
