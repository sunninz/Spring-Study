package com.example.SpringStudy.service.ReviewService;

import com.example.SpringStudy.domain.Review;
import org.springframework.data.domain.Page;

public interface ReviewQueryService {
    // 특정 가게의 리뷰 목록
    Page<Review> getReviewList(Long StoreId, Integer page);
    // 특정 회원의 리뷰 목록
    Page<Review> getReviewsByUser(Long memberId, Integer page);
}
