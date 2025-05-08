package com.example.SpringStudy.service.MissionService;

import com.example.SpringStudy.web.dto.response.HomeReponseDto;

public interface MissionQueryService {
    HomeReponseDto getHomeMissionByMemberId(Long memberId);

}
