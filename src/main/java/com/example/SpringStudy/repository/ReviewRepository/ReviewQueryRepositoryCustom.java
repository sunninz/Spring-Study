package com.example.SpringStudy.repository.ReviewRepository;

import com.example.SpringStudy.domain.Review;

import java.util.List;

public interface ReviewQueryRepositoryCustom {
    List<Review> findAllByStoreId(Long storeId);
}
