package com.example.SpringStudy.repository.FoodCategoryRepository;

import com.example.SpringStudy.domain.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
