package com.example.SpringStudy.domain.mapping;

import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.domain.Mission;
import com.example.SpringStudy.domain.common.BaseEntity;
import com.example.SpringStudy.domain.enums.MissionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'CHALLENGING'")
    private MissionStatus status;

    private Integer verificationCode;

    private LocalDate verifiedAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private Mission mission;

}
