package com.example.jwt.entity.memberDto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MemberLoginResponse {
    private String token;
}
