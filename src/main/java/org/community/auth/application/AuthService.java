package org.community.auth.application;

import org.community.auth.application.dto.CreateUserAuthRequestDto;
import org.community.auth.application.dto.LoginRequestDto;
import org.community.auth.application.dto.UserAccessTokenResponseDto;
import org.community.auth.application.inferfaces.EmailVerificationRepository;
import org.community.auth.application.inferfaces.UserAuthRepository;
import org.community.auth.domain.Email;
import org.community.auth.domain.UserAuth;
import org.community.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final TokenProvider tokenProvider;
    private final EmailVerificationRepository emailVerificationRepository;
    private final UserAuthRepository userAuthRepository;

    public AuthService(
            TokenProvider tokenProvider,
            EmailVerificationRepository emailVerificationRepository,
            UserAuthRepository userAuthRepository
    ) {
        this.tokenProvider = tokenProvider;
        this.emailVerificationRepository = emailVerificationRepository;
        this.userAuthRepository = userAuthRepository;
    }


    public UserAccessTokenResponseDto registerUser(CreateUserAuthRequestDto dto) {
        Email email = Email.createEmail(dto.email());

        if (!emailVerificationRepository.isEmailVerified(email)) {
            throw new IllegalArgumentException("Email is not verified");
        }

        UserAuth userAuth = new UserAuth(dto.email(), dto.password(), dto.role());
        User user = new User(dto.name(), dto.profileImageUrl());
        userAuth = userAuthRepository.registerUser(userAuth, user);

        return createToken(userAuth);
    }

    public UserAccessTokenResponseDto loginUser(LoginRequestDto dto) {
        UserAuth userAuth = userAuthRepository.loginUser(dto.email(), dto.password());
        return createToken(userAuth);
    }

    private UserAccessTokenResponseDto createToken(UserAuth userAuth) {
        String token = tokenProvider.createToken(userAuth.getUserId(), userAuth.getRole());
        return new UserAccessTokenResponseDto(token);
    }
}