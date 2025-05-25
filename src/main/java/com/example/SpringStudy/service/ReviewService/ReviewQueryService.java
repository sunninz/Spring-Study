package com.example.SpringStudy.service.ReviewService;

import com.example.SpringStudy.domain.Review;
import org.springframework.data.domain.Page;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long StoreId, Integer page);
}
