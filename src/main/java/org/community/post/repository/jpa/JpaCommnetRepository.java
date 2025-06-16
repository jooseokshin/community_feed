package org.community.post.repository.jpa;

import org.community.post.repository.entity.comment.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommnetRepository extends JpaRepository<CommentEntity, Long> {
    
}
