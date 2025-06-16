package org.community.user.repository.jpa;

import org.community.user.repository.entity.UserRelationEntity;
import org.community.user.repository.entity.UserRelationIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaUserRelationRepository extends JpaRepository<UserRelationEntity, UserRelationIdEntity> {
}
