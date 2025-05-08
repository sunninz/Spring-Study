package com.example.SpringStudy.repository.MissionRepository;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.web.dto.HomeReponseDto;
import com.example.SpringStudy.web.dto.MyMissionResponseDto;

import java.util.List;

public interface MissionRepositoryCustom {

    HomeReponseDto findHomedataByMemberId(Member member);

}
