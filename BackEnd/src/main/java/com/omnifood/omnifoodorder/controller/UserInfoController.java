package com.omnifood.omnifoodorder.controller;

import com.omnifood.omnifoodorder.dto.LoginResponse;
import com.omnifood.omnifoodorder.model.UserInfo;
import com.omnifood.omnifoodorder.services.AuthoritiesService;
import com.omnifood.omnifoodorder.services.JwtTokenService;
import com.omnifood.omnifoodorder.dto.JwtLogin;
import com.omnifood.omnifoodorder.services.UsersInfoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/v1/api")
public class UserInfoController {

    private JwtTokenService jwtTokenService;
    private UsersInfoServices usersInfoServices;
    private AuthoritiesService authoritiesService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserInfoController(JwtTokenService jwtTokenService, UsersInfoServices usersInfoServices, AuthoritiesService authoritiesService, PasswordEncoder passwordEncoder) {
        this.jwtTokenService = jwtTokenService;
        this.usersInfoServices = usersInfoServices;
        this.authoritiesService = authoritiesService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signin")
    public LoginResponse login(@RequestBody JwtLogin jwtLogin) {
        return jwtTokenService.login(jwtLogin);
    }

    @PostMapping("/signup")
    private void createUser(@RequestBody JwtLogin jwtLogin) {
        UserInfo user = new UserInfo();

        user.setFullName(jwtLogin.getFullName());
        user.setEmail(jwtLogin.getEmail());
        user.setPassword(passwordEncoder.encode(jwtLogin.getPassword()));
        user.setIsActive(1);
        user.getAuthorities().add(authoritiesService.getAuthorities().get(0));
        usersInfoServices.addUser(user);

    }
}
