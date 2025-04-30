package com.example.SpringStudy.domain;

import com.example.SpringStudy.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Inquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private Boolean isReplied;

    private String replyContent;

    private LocalDate repliedAt;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}

