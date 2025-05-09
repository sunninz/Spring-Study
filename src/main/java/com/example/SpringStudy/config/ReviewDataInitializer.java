//package com.example.SpringStudy.config;
//
//
//import com.example.SpringStudy.domain.Member;
//import com.example.SpringStudy.domain.Review;
//import com.example.SpringStudy.domain.Store;
//import com.example.SpringStudy.repository.MemberRepository.MemberRepository;
//import com.example.SpringStudy.repository.ReviewRepository.ReviewRepository;
//import com.example.SpringStudy.repository.StoreRepository.StoreRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class ReviewDataInitializer implements CommandLineRunner {
//
//    private final ReviewRepository reviewRepository;
//    private final StoreRepository storeRepository;
//    private final MemberRepository memberRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        Store store = storeRepository.findById(8L)
//                .orElseThrow(() -> new RuntimeException("Store not found"));
//
//        List<Review> reviews = new ArrayList<>();
//        for (long memberId = 1L; memberId <= 100L; memberId++) {
//            Member member = memberRepository.findById(memberId)
//                    .orElseThrow(() -> new RuntimeException("Member not found"));
//
//            Review review = Review.builder()
//                    .store(store)
//                    .member(member)
//                    .score(4.5f)
//                    .body("리뷰 내용입니다.")
//                    .comment("사장님 답변입니다.")
//                    .build();
//
//            reviews.add(review);
//        }
//
//        reviewRepository.saveAll(reviews);
//        System.out.println("✅ 100개의 리뷰가 저장되었습니다.");
//    }
//}
