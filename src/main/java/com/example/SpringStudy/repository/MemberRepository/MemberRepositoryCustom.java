package com.example.SpringStudy.repository.MemberRepository;

import com.example.SpringStudy.web.dto.response.MemberInfoResponseDto;

public interface MemberRepositoryCustom {

    MemberInfoResponseDto findMemberInfoById(Long memberId);
}
