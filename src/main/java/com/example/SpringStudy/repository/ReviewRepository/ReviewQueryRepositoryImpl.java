package com.example.SpringStudy.repository.ReviewRepository;

import com.example.SpringStudy.domain.QMember;
import com.example.SpringStudy.domain.QReview;
import com.example.SpringStudy.domain.QStore;
import com.example.SpringStudy.domain.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryRepositoryImpl implements ReviewQueryRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private QReview review = QReview.review;
    private QStore store = QStore.store;
    private QMember member= QMember.member;

    @Override
    public List<Review> findAllByStoreId(Long storeId) {
        return jpaQueryFactory
                .selectFrom(review)
                .join(review.store, store).fetchJoin()
                .join(review.member, member).fetchJoin()
                .where(store.id.eq(storeId))
                .fetch();
    }
}
