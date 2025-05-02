package com.example.SpringStudy.web.controller;

import com.example.SpringStudy.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @DeleteMapping("{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }

}
