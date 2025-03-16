package org.community.user.application.interfaces;

import org.community.user.domain.User;

public interface UserRelationRepository {

    boolean isAlreadyFollow(User user, User targerUser);

    void save(User user, User targetUser);

    void delete(User user, User targetUser);
}
