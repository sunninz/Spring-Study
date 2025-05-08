package com.example.SpringStudy.service.MissionService;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.repository.MemberRepository.MemberRepository;
import com.example.SpringStudy.repository.MissionRepository.MissionRepository;
import com.example.SpringStudy.web.dto.response.HomeReponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService{

    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Override
    public HomeReponseDto getHomeMissionByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        return missionRepository.findHomedataByMemberId(member);
    }
}
