package com.example.SpringStudy.web.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDTO {

    @Getter
    public static class ChallengeDTO {
        @NotNull
        private Long memberId;
        @NotNull
        private Long missionId;
    }
}
