package com.example.SpringStudy.web.controller;

import com.example.SpringStudy.apiPayload.ApiResponse;
import com.example.SpringStudy.converter.ReviewConverter;
import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.service.ReviewService.ReviewService;
import com.example.SpringStudy.service.StoreService.StoreQueryService;
import com.example.SpringStudy.web.dto.request.ReviewRequestDTO;
import com.example.SpringStudy.web.dto.response.ReviewResponseDTO;
import com.example.SpringStudy.web.dto.response.StoreReviewResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    // storeId로 리뷰 조회
    @GetMapping("/{storeId}")
    public List<StoreReviewResponseDto> getStoreReviews(@PathVariable("storeId") Long storeId) {
        long start = System.currentTimeMillis();

        List<StoreReviewResponseDto> result = reviewService.getReviewsByStoreId(storeId);

        long end = System.currentTimeMillis();
        System.out.println("[⏱️ 실행 시간] getReviewsByStoreId: " + (end - start) + "ms");

        return reviewService.getReviewsByStoreId(storeId);
    }

    // 리뷰 작성
    @PostMapping("/create")
    public ApiResponse<ReviewResponseDTO.CreateResultDTO> createReview(@RequestBody @Valid ReviewRequestDTO.CreateDTO request) {
        Review review = reviewService.createReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(review));
    }
}
