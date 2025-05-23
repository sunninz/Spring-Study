package com.example.SpringStudy.web.dto.request;

import com.example.SpringStudy.validation.annotation.ExistMember;
import com.example.SpringStudy.validation.annotation.ExistStore;
import jakarta.validation.constraints.*;
import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class CreateDTO {
        @NotNull
        private String body;

        @NotNull
        @DecimalMin(value = "0.5")
        @DecimalMax(value = "5.0")
        private Float score;

        @NotNull
        @ExistStore
        private Long storeId;

        @NotNull
        @ExistMember
        private Long memberId;
    }
}
