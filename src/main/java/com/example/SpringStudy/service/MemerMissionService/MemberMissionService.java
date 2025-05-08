package com.example.SpringStudy.service.MemerMissionService;

import com.example.SpringStudy.web.dto.HomeReponseDto;

public interface MemberMissionService {
    HomeReponseDto getHomeInfoByMemberId(Long memberId);
}
