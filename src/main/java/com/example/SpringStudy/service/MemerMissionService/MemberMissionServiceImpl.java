package com.example.SpringStudy.service.MemerMissionService;

import com.example.SpringStudy.repository.MemberMissionRepository.MemberMissionRepository;
import com.example.SpringStudy.web.dto.HomeReponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public HomeReponseDto getHomeInfoByMemberId(Long memberId) {
        return null;
    }
}
