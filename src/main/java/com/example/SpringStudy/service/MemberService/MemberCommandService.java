package com.example.SpringStudy.service.MemberService;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.web.dto.request.MemberRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberInfoResponseDto;

import java.util.List;

public interface MemberCommandService {

    // 회원 탈퇴
    void deleteMember(Long memberId);

    // 회원 정보 조회
    MemberInfoResponseDto getMemberInfo(Long memberId);

    // 회원 가입
    Member joinMember(MemberRequestDTO.JoinDto request);

    // 카테고리 검증
    boolean allExist(List<Long> values);
}
