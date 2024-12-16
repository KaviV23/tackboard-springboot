package com.kavirajv.tackboard.controller;

import com.kavirajv.tackboard.domain.User;
import com.kavirajv.tackboard.dto.LoginRequest;
import com.kavirajv.tackboard.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
//    @Autowired
//    private UserService userService;
//
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            Authentication authenticate = authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken(
                            request.getUsername(), request.getPassword()
                            )
                    );
            User user = (User) authenticate.getPrincipal();
            user.setPassword(null);

            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtUtil.generateToken(user.getUsername()))
                    .body(user);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody User user) {
//        User savedUser = userService.register(user);
//        return ResponseEntity.ok(savedUser);
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//        UserDetails user = userService.loadUserByUsername(request.getUsername());
//
//        if (!new BCryptPasswordEncoder().matches(request.getPassword(), user.getPassword())) {
//            throw new RuntimeException("Invalid credentials");
//        }
//
//        String token = jwtUtil.generateToken(user.getUsername());
//        return ResponseEntity.ok(new LoginResponse(token));
//    }

}