package com.example.SpringStudy.web.controller;

import com.example.SpringStudy.apiPayload.ApiResponse;
import com.example.SpringStudy.converter.MemberMissionConverter;
import com.example.SpringStudy.converter.MissionConverter;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.service.MemberMissionService.MemberMissionCommandService;
import com.example.SpringStudy.web.dto.request.MemberMissionRequestDTO;
import com.example.SpringStudy.web.dto.request.MissionRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberMissionResponseDTO;
import com.example.SpringStudy.web.dto.response.MissionResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member-missions")
@RequiredArgsConstructor
public class MemberMissionController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.CreateChallengeResultDTO> createChallange(@RequestBody @Valid MemberMissionRequestDTO.ChallengeDTO request){

        MemberMission result= memberMissionCommandService.createChallenge(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateChallengeResultDTO(result));
    }
}
