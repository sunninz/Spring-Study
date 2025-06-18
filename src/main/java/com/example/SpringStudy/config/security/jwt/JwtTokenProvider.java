package com.example.SpringStudy.config.security.jwt;

import com.example.SpringStudy.apiPayload.code.status.ErrorStatus;
import com.example.SpringStudy.apiPayload.exception.handler.MemberHandler;
import com.example.SpringStudy.config.properties.Constants;
import com.example.SpringStudy.config.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes());
    }

    // 토큰 생성
    public String generateToken(Authentication authentication){
        String email = authentication.getName();

        return Jwts.builder()
                .setSubject(email)
                .claim("role",authentication.getAuthorities().iterator().next().getAuthority())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration().getAccess()))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 토큰 검증
    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (JwtException | IllegalArgumentException e){
            return false;
        }
    }

    // 토큰에서 인증 정보 추출 -> authentication 객체 변환
    public Authentication getAuthentication(String token){
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String email = claims.getSubject();
        String role = claims.get("role", String.class);

        User principal = new User(email,"", Collections.singleton(()-> role));
        return new UsernamePasswordAuthenticationToken(principal,token,principal.getAuthorities());
    }

    public static String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(Constants.AUTH_HEADER);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith(Constants.TOKEN_PREFIX)){
            return bearerToken.substring(Constants.TOKEN_PREFIX.length());
        }
        return null;
    }

    // 토큰 추출
    public Authentication extractAuthentication(HttpServletRequest request){
        String accessToken = resolveToken(request);
        if(accessToken == null || !validateToken(accessToken)){
            throw new MemberHandler(ErrorStatus.INVALID_TOKEN);
        }
        return getAuthentication(accessToken);
    }
}
