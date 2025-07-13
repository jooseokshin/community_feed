package org.community.auth.application.inferfaces;

import org.community.auth.domain.Email;

public interface EmailSendRepository {
    void sendVerificationEmail(Email email, String token);
}
