package com.example.SpringStudy.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberInfoResponseDto {
    private String name;
    private String email;
    private Integer phoneNumber;
    private Integer point;

    @Override
    public String toString() {
        return "MemberInfoDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", point=" + point +
                '}';
    }
}
