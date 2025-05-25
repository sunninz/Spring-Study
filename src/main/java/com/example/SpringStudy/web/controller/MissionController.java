package com.example.SpringStudy.web.controller;

import com.example.SpringStudy.apiPayload.ApiResponse;
import com.example.SpringStudy.converter.MemberConverter;
import com.example.SpringStudy.converter.MissionConverter;
import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.service.MemberService.MemberCommandService;
import com.example.SpringStudy.service.MissionService.MissionCommandService;
import com.example.SpringStudy.validation.annotation.ExistStore;
import com.example.SpringStudy.validation.annotation.ValidPage;
import com.example.SpringStudy.web.dto.request.MemberRequestDTO;
import com.example.SpringStudy.web.dto.request.MissionRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberResponseDTO;
import com.example.SpringStudy.web.dto.response.MissionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.CreateResultDTO> createMission(@RequestBody @Valid MissionRequestDTO.CreateMissionDTO request){
        Mission mission = missionCommandService.createMission(request);

        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }

    @GetMapping("/{storeId}")
    @Operation(summary="특정 가게의 미션 목록 조회 API",description="특정 가게의 미션 목록들을 조회하는 API, query string으로 page번호를 주세요")
    public ApiResponse<MissionResponseDTO.MissionInfoListDTO> getMissionByStore(@PathVariable("storeId") @ExistStore Long storeId, @ValidPage @RequestParam(name="page") Integer page){
        Page<Mission> missionList = missionCommandService.getMissionByStore(storeId,page);
        return ApiResponse.onSuccess(MissionConverter.missionInfoListDTO(missionList));
    }
}