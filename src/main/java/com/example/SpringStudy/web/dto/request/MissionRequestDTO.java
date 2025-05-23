package com.example.SpringStudy.web.dto.request;

import com.example.SpringStudy.validation.annotation.ExistStore;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class CreateMissionDTO {
        @NotNull
        private LocalDate deadline;
        @NotNull
        private String missionDescription;

        @Min(value = 500)
        @Max(value = 2000)
        private Integer reward;
        @NotNull
        @ExistStore
        private Long storeId;
    }
}
