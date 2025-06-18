package com.example.SpringStudy.service.MemberService;

import com.example.SpringStudy.apiPayload.code.status.ErrorStatus;
import com.example.SpringStudy.apiPayload.exception.handler.MemberHandler;
import com.example.SpringStudy.config.security.jwt.JwtTokenProvider;
import com.example.SpringStudy.converter.MemberConverter;
import com.example.SpringStudy.domain.Member;
import com.example.SpringStudy.repository.MemberRepository.MemberRepository;
import com.example.SpringStudy.web.dto.response.MemberResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final JwtTokenProvider jwtTokenProvider;
    private final MemberRepository memberRepository;

    @Override
    public MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request) {
        Authentication authentication = jwtTokenProvider.extractAuthentication(request);
        String email = authentication.getName();
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        return MemberConverter.toMemberInfoDTO(member);
    }
}
