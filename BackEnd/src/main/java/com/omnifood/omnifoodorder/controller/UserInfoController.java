package com.omnifood.omnifoodorder.controller;

import com.omnifood.omnifoodorder.services.JwtTokenService;
import com.omnifood.omnifoodorder.dto.JwtLogin;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/v1/api")
public class UserInfoController {
    @Autowired
    private JwtTokenService jwtTokenService;

    @PostMapping("/signin")
    public String login(@RequestBody JwtLogin jwtLogin){
        return jwtTokenService.login(jwtLogin);
    }
}
