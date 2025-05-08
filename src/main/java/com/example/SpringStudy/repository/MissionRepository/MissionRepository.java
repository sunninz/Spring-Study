package com.example.SpringStudy.repository.MissionRepository;

import com.example.SpringStudy.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission,Long>, MissionRepositoryCustom {
}
