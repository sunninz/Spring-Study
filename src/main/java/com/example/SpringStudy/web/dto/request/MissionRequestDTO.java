package com.example.SpringStudy.web.dto.request;

import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class CreateMissionDTO {
        private LocalDate deadline;
        private String missionDescription;
        private Integer reward;
        private Long storeId;
    }
}
