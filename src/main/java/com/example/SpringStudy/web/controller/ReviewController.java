package com.example.SpringStudy.web.controller;

import com.example.SpringStudy.service.ReviewService.ReviewService;
import com.example.SpringStudy.service.StoreService.StoreQueryService;
import com.example.SpringStudy.web.dto.response.StoreReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    // storeId로 리뷰 조회
    @GetMapping("/{storeId}")
    public List<StoreReviewResponseDto> getStoreReviews(@PathVariable("storeId") Long storeId){
        return reviewService.getReviewsByStoreId(storeId);
    }

}
