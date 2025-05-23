package com.example.SpringStudy.converter;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.domain.Store;
import com.example.SpringStudy.domain.enums.MissionStatus;
import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.web.dto.request.ReviewRequestDTO;
import com.example.SpringStudy.web.dto.response.MemberMissionResponseDTO;
import com.example.SpringStudy.web.dto.response.ReviewResponseDTO;
import com.example.SpringStudy.web.dto.response.StoreReviewResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
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

    public static ReviewResponseDTO.CreateResultDTO toCreateResultDTO(Review review){
        return ReviewResponseDTO.CreateResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateDTO request,Member member, Store store){
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .member(member)
                .store(store)
                .build();

    }
}
