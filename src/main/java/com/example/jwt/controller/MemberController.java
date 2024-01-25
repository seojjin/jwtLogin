package com.example.jwt.controller;

import com.example.jwt.entity.memberDto.*;
import com.example.jwt.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<MemberRegisterResponse> register(@RequestBody MemberRegisterRequest memberRegisterRequest){
        try{
            MemberDto memberDto = memberService.register(memberRegisterRequest);
            return new ResponseEntity<>(new MemberRegisterResponse(memberDto.getEmployName()), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody MemberLoginRequest memberLoginRequest){
        try{
            String token = memberService.login(memberLoginRequest.getEmployNumber(), memberLoginRequest.getPassword());
            return new ResponseEntity<>(new MemberLoginResponse(token), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
