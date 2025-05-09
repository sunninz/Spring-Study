package com.example.SpringStudy.service.ReviewService;

import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.repository.ReviewRepository.ReviewRepository;
import com.example.SpringStudy.web.dto.response.StoreReviewResponseDto;
import com.example.SpringStudy.converter.ReviewConverter.ReviewConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    @Override
    public List<StoreReviewResponseDto> getReviewsByStoreId(Long storeId) {

        return reviewRepository.findAllByStoreId(storeId)
                .stream()
                .map(ReviewConverter::toReviewResponseDto)
                .collect(Collectors.toList());
    }
}
