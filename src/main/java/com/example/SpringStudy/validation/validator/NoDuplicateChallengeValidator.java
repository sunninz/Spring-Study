package com.example.SpringStudy.validation.validator;

import com.example.SpringStudy.apiPayload.code.status.ErrorStatus;
import com.example.SpringStudy.service.MemberMissionService.MemberMissionCommandService;
import com.example.SpringStudy.validation.annotation.NoDuplicateChallenge;
import com.example.SpringStudy.web.dto.request.MemberMissionRequestDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class NoDuplicateChallengeValidator implements ConstraintValidator<NoDuplicateChallenge, MemberMissionRequestDTO.ChallengeDTO>{

    private final MemberMissionCommandService memberMissionCommandService;

    @Override
    public void initialize(NoDuplicateChallenge constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MemberMissionRequestDTO.ChallengeDTO value, ConstraintValidatorContext context) {
        boolean alreadyChallenged = memberMissionCommandService.challengeExist(value);

        if (alreadyChallenged){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_CHALLENGED.toString())
                    .addPropertyNode("_global")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
