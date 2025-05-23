package com.example.SpringStudy.validation.annotation;

import com.example.SpringStudy.validation.validator.NoDuplicateChallengeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NoDuplicateChallengeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NoDuplicateChallenge {
    String message() default "이미 도전 중이거나 완료된 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
