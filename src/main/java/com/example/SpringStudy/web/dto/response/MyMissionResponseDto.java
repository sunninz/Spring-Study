package com.example.SpringStudy.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MyMissionResponseDto {
    private String storeName;
    private String storeCategory;
    private String missionDescription;
    private Integer reward;
    private LocalDate deadline;

    @Override
    public String toString() {
        return "MyMissionResponseDto{" +
                "storeName='" + storeName + '\'' +
                ", storeCategory='" + storeCategory + '\'' +
                ", missionDescription='" + missionDescription + '\'' +
                ", reward=" + reward +
                ", deadline=" + deadline +
                '}';
    }
}
