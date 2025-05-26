package com.example.SpringStudy.web.controller;

import com.example.SpringStudy.apiPayload.ApiResponse;
import com.example.SpringStudy.converter.MemberMissionConverter;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.service.MemberMissionService.MemberMissionCommandService;
import com.example.SpringStudy.validation.annotation.ExistMember;
import com.example.SpringStudy.validation.annotation.ValidPage;
import com.example.SpringStudy.web.dto.request.MemberMissionRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberMissionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member-missions")
@RequiredArgsConstructor
@Validated
public class MemberMissionController {
    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/challenge")
    public ApiResponse<MemberMissionResponseDTO.CreateChallengeResultDTO> createChallange(@RequestBody @Valid MemberMissionRequestDTO.ChallengeDTO request){

        MemberMission result= memberMissionCommandService.createChallenge(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toCreateChallengeResultDTO(result));
    }

    // 내가 진행중인 미션 목록 조회
    @GetMapping("")
    @Operation(summary="특정 회원의 미션 목록 조회 API", description = "특정 회원의 미션을 조회하는 API 이며 query string으로 memberId, page, status를 주세요")
    public ApiResponse<MemberMissionResponseDTO.MissionInfoListDTO> getMissionInfo(
            @ExistMember @RequestParam(name="memberId")Long memberId, @ValidPage @RequestParam(name = "page") Integer page , @RequestParam(name="status") MissionStatus status){
        Page<MemberMission> memberMissionList = memberMissionCommandService.getMissionsByMemberAndStatus(memberId, page, status);
        return ApiResponse.onSuccess(MemberMissionConverter.missionInfoListDTO(memberMissionList));
    }

}
