package org.community.auth.application.inferfaces;

import org.community.auth.domain.Email;

public interface EmailVerificationRepository {
    void createEmailVerification(Email email, String token);

    void verifyEmail(Email email, String token);

    boolean isEmailVerified(Email email);
}