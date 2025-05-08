package com.example.SpringStudy.service.MemberService;

import com.example.SpringStudy.repository.MemberAgreeRepository.MemberAgreeRepository;
import com.example.SpringStudy.repository.MemberMissionRepository.MemberMissionRepository;
import com.example.SpringStudy.repository.MemberPreferRepository.MemberPreferRepository;
import com.example.SpringStudy.repository.MemberRepository.MemberRepository;
import com.example.SpringStudy.web.dto.MemberInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MemberPreferRepository memberPreferRepository;
    private final MemberAgreeRepository memberAgreeRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public void deleteMember(Long memberId) {
        memberPreferRepository.deleteByMemberId(memberId);
        memberAgreeRepository.deleteByMemberId(memberId);
        memberMissionRepository.deleteByMemberId(memberId);

        memberRepository.deleteById(memberId);
    }

    @Override
    public MemberInfoDto getMemberInfo(Long memberId) {
        return memberRepository.findMemberInfoById(memberId);
    }
}
