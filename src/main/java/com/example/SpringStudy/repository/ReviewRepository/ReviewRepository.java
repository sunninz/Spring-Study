package com.example.SpringStudy.repository.ReviewRepository;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Review;
import com.example.SpringStudy.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Query("SELECT r FROM Review r WHERE r.store.id = :storeId")
    List<Review> findAllByStoreId(@Param("storeId")Long storeId);

//    @Query("SELECT r FROM Review r " +
//            "JOIN FETCH r.store s " +
//            "JOIN FETCH r.member m " +
//            "WHERE s.id = :storeId")
//    List<Review> findAllByStoreId(@Param("storeId") Long storeId);

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
