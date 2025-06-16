package org.community.user.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.community.user.application.interfaces.UserRelationRepository;
import org.community.user.domain.User;
import org.community.user.repository.entity.UserEntity;
import org.community.user.repository.entity.UserRelationEntity;
import org.community.user.repository.entity.UserRelationIdEntity;
import org.community.user.repository.jpa.JpaUserRelationRepository;
import org.community.user.repository.jpa.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRelationRepositoryImpl implements UserRelationRepository {

    private final JpaUserRelationRepository jpaUserRelationRepository;
    private final JpaUserRepository jpaUserRepository;

    @Override
    public boolean isAlreadyFollow(User user, User targerUser) {
        UserRelationIdEntity id = new UserRelationIdEntity(user.getId(), targerUser.getId());
        return jpaUserRelationRepository.existsById(id);
    }

    @Override
    @Transactional
    public void save(User user, User targetUser) {
        UserRelationEntity entity = new UserRelationEntity(user.getId(), targetUser.getId());
        jpaUserRelationRepository.save(entity);
        jpaUserRepository.saveAll(List.of(new UserEntity(user), new UserEntity(targetUser)));
    }

    @Override
    @Transactional
    public void delete(User user, User targetUser) {
        UserRelationIdEntity id = new UserRelationIdEntity(user.getId(), targetUser.getId());
        jpaUserRelationRepository.deleteById(id);
        jpaUserRepository.saveAll(List.of(new UserEntity(user), new UserEntity(targetUser)));

    }
}
