package com.example.SpringStudy.repository.MemberRepository;

import com.example.SpringStudy.web.dto.MemberInfoDto;

public interface MemberRepositoryCustom {

    MemberInfoDto findMemberInfoById(Long memberId);
}
