package com.example.SpringStudy.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class StoreReviewResponseDto {
    private Long reviewId;
    private String storeName;
    private String reviewrName;
    private String body;
    private Float score;
    private String comment;
}
