package com.example.SpringStudy.web.controller;

import com.example.SpringStudy.service.MemberService.MemberCommandService;
import com.example.SpringStudy.web.dto.request.MemberRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberViewController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/members/signup")
    public String joinMember(@ModelAttribute("memberJoinDto") @Valid MemberRequestDTO.JoinDto request,
                             BindingResult bindingResult,
                             Model model){

        if(bindingResult.hasErrors()){
            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지
            return "signup";
        }

        try{
            memberCommandService.joinMember(request);
            return "redirect:/login";
        } catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "signup";
        }

    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model){
        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home(Authentication authentication){
        System.out.println("✅ 현재 로그인 유저: " + (authentication != null ? authentication.getName() : "없음"));
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}
