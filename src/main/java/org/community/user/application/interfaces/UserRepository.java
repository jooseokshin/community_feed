package org.community.user.application.interfaces;

import org.community.user.domain.User;

public interface UserRepository {

    User save(User user);

    User findById(Long id);
}
