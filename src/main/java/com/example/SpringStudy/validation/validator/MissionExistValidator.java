package com.example.SpringStudy.validation.validator;

import com.example.SpringStudy.apiPayload.code.status.ErrorStatus;
import com.example.SpringStudy.service.MemberService.MemberCommandService;
import com.example.SpringStudy.service.MissionService.MissionCommandService;
import com.example.SpringStudy.validation.annotation.ExistCategories;
import com.example.SpringStudy.validation.annotation.ExistrMission;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MissionExistValidator implements ConstraintValidator<ExistrMission, Long> {

    private final MissionCommandService missionCommandService;

    @Override
    public void initialize(ExistrMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionCommandService.missionExist(value);

        if (!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSON_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}