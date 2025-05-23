package com.example.SpringStudy.service.MissionService;

import com.example.SpringStudy.apiPayload.exception.handler.FoodCategoryHandler;
import com.example.SpringStudy.apiPayload.exception.handler.MissionHandler;
import com.example.SpringStudy.converter.MissionConverter;
import com.example.SpringStudy.domain.FoodCategory;
import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.Store;
import com.example.SpringStudy.domain.mapping.MemberPrefer;
import com.example.SpringStudy.repository.MissionRepository.MissionRepository;
import com.example.SpringStudy.repository.StoreRepository.StoreRepository;
import com.example.SpringStudy.web.dto.request.MemberRequestDTO;
import com.example.SpringStudy.web.dto.request.MissionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.SpringStudy.apiPayload.code.status.ErrorStatus.STORE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MissionConverter missionConverter;
    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Transactional
    @Override
    public Mission createMission(MissionRequestDTO.CreateMissionDTO request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new MissionHandler(STORE_NOT_FOUND));

        Mission mission = missionConverter.toMission(request, store);
        return missionRepository.save(mission);
    }
}