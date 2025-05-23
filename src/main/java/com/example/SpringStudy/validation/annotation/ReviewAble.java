package com.example.SpringStudy.validation.annotation;

import com.example.SpringStudy.validation.validator.ReviewAbleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ReviewAbleValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReviewAble {
    String message() default "해당 가게의 미션을 완료한 경우에만 리뷰를 작성할 수 있습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}