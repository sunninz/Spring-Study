package com.example.SpringStudy.validation.validator;

import com.example.SpringStudy.apiPayload.code.status.ErrorStatus;
import com.example.SpringStudy.service.MemberMissionService.MemberMissionCommandService;
import com.example.SpringStudy.validation.annotation.ReviewAble;
import com.example.SpringStudy.web.dto.request.ReviewRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReviewAbleValidator implements ConstraintValidator<ReviewAble, ReviewRequestDTO.CreateDTO> {

    private final MemberMissionCommandService memberMissionCommandService;
    @Override
    public void initialize(ReviewAble constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ReviewRequestDTO.CreateDTO value, ConstraintValidatorContext context) {
        boolean isCompleted = memberMissionCommandService.completedMission(value);

        if (!isCompleted){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.REVIEW_NOT_ALLOWED.toString())
                    .addPropertyNode("_global")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
