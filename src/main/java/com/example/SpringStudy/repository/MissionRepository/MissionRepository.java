package com.example.SpringStudy.repository.MissionRepository;

import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long>, MissionRepositoryCustom {
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
