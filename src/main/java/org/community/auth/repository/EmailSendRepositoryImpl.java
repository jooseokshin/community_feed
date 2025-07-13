package org.community.auth.repository;

import org.community.auth.application.inferfaces.EmailSendRepository;
import org.community.auth.domain.Email;
import org.springframework.stereotype.Repository;

@Repository
public class EmailSendRepositoryImpl implements EmailSendRepository {

    @Override
    public void sendVerificationEmail(Email email, String token) {
        // send email
    }
}
