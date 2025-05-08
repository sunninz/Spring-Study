package com.example.SpringStudy.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class HomeReponseDto {
    private String regionName;
    private Integer point;
    private Long completedMissionCount;
    private List<MyMissionResponseDto> missions;

    @Override
    public String toString() {
        return "HomeReponseDto{" +
                "regionName='" + regionName + '\'' +
                ", point=" + point +
                ", completedMissionCount=" + completedMissionCount +
                ", missions=" + missions +
                '}';
    }
}
