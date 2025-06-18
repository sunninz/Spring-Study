package com.example.SpringStudy.service.MemberService;

import com.example.SpringStudy.web.dto.response.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface MemberQueryService {
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}
