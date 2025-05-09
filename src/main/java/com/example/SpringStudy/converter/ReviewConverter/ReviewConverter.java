package com.example.SpringStudy.converter.ReviewConverter;

import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.web.dto.response.StoreReviewResponseDto;

public class ReviewConverter {
    public static StoreReviewResponseDto toReviewResponseDto(Review r) {
        return new StoreReviewResponseDto(
                r.getId(),
                r.getStore().getName(),
                r.getMember().getName(),
                r.getBody(),
                r.getScore(),
                r.getComment()
        );
    }
}
