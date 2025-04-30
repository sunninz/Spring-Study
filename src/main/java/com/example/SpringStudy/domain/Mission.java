package com.example.SpringStudy.domain;

import com.example.SpringStudy.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String missionDescription;

    private Integer reward;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
}
