package com.example.SpringStudy.service.ReviewService;

import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.web.dto.request.ReviewRequestDTO;
import com.example.SpringStudy.web.dto.response.StoreReviewResponseDto;

import java.util.List;

public interface ReviewService {
    List<StoreReviewResponseDto> getReviewsByStoreId(Long storeId);

    Review createReview(ReviewRequestDTO.CreateDTO request);
}
