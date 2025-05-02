package com.example.SpringStudy.service;

import com.example.SpringStudy.repository.MemberAgreeRepository;
import com.example.SpringStudy.repository.MemberMissionRepository;
import com.example.SpringStudy.repository.MemberPreferRepository;
import com.example.SpringStudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

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
}
