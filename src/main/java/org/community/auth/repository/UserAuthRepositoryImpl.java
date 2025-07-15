package org.community.auth.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.community.auth.application.inferfaces.UserAuthRepository;
import org.community.auth.domain.UserAuth;
import org.community.auth.repository.entity.UserAuthEntity;
import org.community.auth.repository.jpa.JpaUserAuthRepository;
import org.community.user.application.interfaces.UserRepository;
import org.community.user.domain.User;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserAuthRepositoryImpl implements UserAuthRepository {

    private final JpaUserAuthRepository jpaUserAuthRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserAuth registerUser(UserAuth userAuth, User user) {
        User savedUser = userRepository.save(user);
        UserAuthEntity userAuthEntity = new UserAuthEntity(userAuth, savedUser.getId());
        userAuthEntity = jpaUserAuthRepository.save(userAuthEntity);
        return userAuthEntity.toUserAuth();
    }

    @Override
    @Transactional
    public UserAuth loginUser(String email, String password) {
        UserAuthEntity userAuthEntity = jpaUserAuthRepository.findByEmail(email).orElseThrow();

        UserAuth userAuth = userAuthEntity.toUserAuth();
        if (!userAuth.matchPassword(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        userAuthEntity.updateLastLoginAt();
        return userAuth;
    }
}