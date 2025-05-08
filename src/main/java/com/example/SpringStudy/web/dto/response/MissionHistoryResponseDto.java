package com.example.SpringStudy.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionHistoryResponseDto {
    private String storeName;
    private String missionDescription;
    private Integer reward;

    @Override
    public String toString() {
        return "MissionHistoryResponseDto{" +
                "storeName='" + storeName + '\'' +
                ", missionDescription='" + missionDescription + '\'' +
                ", reward=" + reward +
                '}';
    }
}
