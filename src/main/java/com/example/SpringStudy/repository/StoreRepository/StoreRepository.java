package com.example.SpringStudy.repository.StoreRepository;

import com.example.SpringStudy.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository <Store,Long>, StoreRepositoryCustom {
}
