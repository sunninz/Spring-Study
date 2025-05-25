package com.example.SpringStudy.service.ReviewService;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.domain.Store;
import com.example.SpringStudy.repository.MemberRepository.MemberRepository;
import com.example.SpringStudy.repository.ReviewRepository.ReviewRepository;
import com.example.SpringStudy.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page,10));
        return StorePage;
    }

    @Override
    public Page<Review> getReviewsByUser(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Page<Review> reviewPage = reviewRepository.findAllByMember(member,PageRequest.of(page-1,10));
        return reviewPage;
    }
}
