package org.community.post.repository.jpa;

import org.community.post.repository.entity.like.LikeEntity;
import org.community.post.repository.entity.like.LikeIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaLikeRepository extends JpaRepository<LikeEntity, LikeIdEntity> {
    
}
