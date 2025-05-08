package com.example.SpringStudy.service.MemberService;

import com.example.SpringStudy.web.dto.MemberInfoDto;

public interface MemberService {

    // 회원 탈퇴
    void deleteMember(Long memberId);

    // 회원 정보 조회
    MemberInfoDto getMemberInfo(Long memberId);
}
