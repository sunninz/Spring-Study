package com.example.SpringStudy.repository.MissionRepository;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.web.dto.response.HomeReponseDto;

public interface MissionRepositoryCustom {

    HomeReponseDto findHomedataByMemberId(Member member);

}
