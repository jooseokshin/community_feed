package org.community.auth.application.inferfaces;

import org.community.auth.domain.UserAuth;
import org.community.user.domain.User;

public interface UserAuthRepository {
    UserAuth registerUser(UserAuth userAuth, User user);
    UserAuth loginUser(String email, String password);
}