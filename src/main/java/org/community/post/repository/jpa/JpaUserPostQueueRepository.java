package org.community.post.repository.jpa;

import org.community.post.repository.entity.post.UserPostQueueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserPostQueueRepository extends JpaRepository<UserPostQueueEntity, Long> {
    void deleteAllByUserIdAndAuthorId(Long userId, Long authorId);
}
