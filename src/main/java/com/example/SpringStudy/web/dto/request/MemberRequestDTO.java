package com.example.SpringStudy.web.dto.request;

import com.example.SpringStudy.domain.enums.Role;
import com.example.SpringStudy.validation.annotation.ExistCategories;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    @Setter
    @ToString
    public static class JoinDto{
        @NotBlank
        @Email
        String email;
        @NotBlank
        String password;
        @NotNull
        Role role;
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @NotNull
        Integer birthYear;
        @NotNull
        Integer birthMonth;
        @NotNull
        Integer birthDay;

        String address;

        String specAddress;
        @NotBlank
        String phoneNumber;
//        @ExistCategories
        List<Long> preferCategory;
    }


}
