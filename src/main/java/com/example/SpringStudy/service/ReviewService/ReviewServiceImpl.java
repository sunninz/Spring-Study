package com.example.SpringStudy.service.ReviewService;

import com.example.SpringStudy.converter.MemberMissionConverter;
import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.domain.Store;
import com.example.SpringStudy.domain.mapping.MemberMission;
import com.example.SpringStudy.repository.MemberRepository.MemberRepository;
import com.example.SpringStudy.repository.ReviewRepository.ReviewQueryRepository;
import com.example.SpringStudy.repository.ReviewRepository.ReviewRepository;
import com.example.SpringStudy.repository.StoreRepository.StoreRepository;
import com.example.SpringStudy.web.dto.request.ReviewRequestDTO;
import com.example.SpringStudy.web.dto.response.StoreReviewResponseDto;
import com.example.SpringStudy.converter.ReviewConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final ReviewQueryRepository reviewQueryRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewConverter reviewConverter;

    @Transactional(readOnly = true)
    @Override
    public List<StoreReviewResponseDto> getReviewsByStoreId(Long storeId) {

        return reviewRepository.findAllByStoreId(storeId)
                .stream()
                .map(ReviewConverter::toReviewResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Review createReview(ReviewRequestDTO.CreateDTO request) {

        Long memberId = request.getMemberId();
        Long storeId = request.getStoreId();

        Member member = memberRepository.findById(memberId)
                .orElseThrow();

        Store store = storeRepository.findById(storeId)
                .orElseThrow();

        Review review = reviewConverter.toReview(request,member,store);
        return reviewRepository.save(review);
    }
}
