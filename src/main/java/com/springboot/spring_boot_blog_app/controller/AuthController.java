package com.springboot.spring_boot_blog_app.controller;

import com.springboot.spring_boot_blog_app.payload.JwtAuthResponse;
import com.springboot.spring_boot_blog_app.payload.LoginDto;
import com.springboot.spring_boot_blog_app.payload.RegisterDto;
import com.springboot.spring_boot_blog_app.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    //Build Login rest apis
    //either login or signin url
    @PostMapping(value={"/login","/signin"})
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
        String token= authService.login(loginDto);
        JwtAuthResponse jwtAuthResponse=new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }
@PostMapping(value = {"/register","/signin"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        String response= authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
