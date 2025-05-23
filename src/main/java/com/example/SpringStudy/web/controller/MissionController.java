package com.example.SpringStudy.web.controller;

import com.example.SpringStudy.apiPayload.ApiResponse;
import com.example.SpringStudy.converter.MemberConverter;
import com.example.SpringStudy.converter.MissionConverter;
import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.service.MemberService.MemberCommandService;
import com.example.SpringStudy.service.MissionService.MissionCommandService;
import com.example.SpringStudy.web.dto.request.MemberRequestDTO;
import com.example.SpringStudy.web.dto.request.MissionRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberResponseDTO;
import com.example.SpringStudy.web.dto.response.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> createMission(@RequestBody @Valid MissionRequestDTO.CreateMissionDTO request){
        Mission mission = missionCommandService.createMission(request);

        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }

}
