package com.example.SpringStudy.repository.ReviewRepository;

import com.example.SpringStudy.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewQueryRepository extends JpaRepository<Review, Long>,ReviewQueryRepositoryCustom {
}
