package org.community.auth.ui;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.community.auth.application.AuthService;
import org.community.auth.application.EmailService;
import org.community.auth.application.dto.CreateUserAuthRequestDto;
import org.community.auth.application.dto.SendEmailRequestDto;
import org.community.auth.application.dto.UserAccessTokenResponseDto;
import org.community.common.ui.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {

    private final EmailService emailService;
    private final AuthService authService;

    @PostMapping("/send-verification-email")
    public Response<Void> sendEmail(@RequestBody SendEmailRequestDto dto) {
        emailService.sendEmail(dto);
        return Response.ok(null);
    }

    @GetMapping("/verify-email")
    public Response<Void> verifyEmail(String email, String token) {
        emailService.verify(email, token);
        return Response.ok(null);
    }

    @PostMapping("/register")
    public Response<UserAccessTokenResponseDto> register(@RequestBody CreateUserAuthRequestDto dto) {
        return Response.ok(authService.registerUser(dto));
    }
}