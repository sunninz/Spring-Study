package com.example.SpringStudy.web.dto.request;

import com.example.SpringStudy.validation.annotation.ExistMember;
import com.example.SpringStudy.validation.annotation.ExistrMission;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDTO {

    @Getter
    public static class ChallengeDTO {
        @NotNull
        @ExistMember
        private Long memberId;

        @NotNull
        @ExistrMission
        private Long missionId;
    }
}
