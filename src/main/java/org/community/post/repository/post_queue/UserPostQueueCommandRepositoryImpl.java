package org.community.post.repository.post_queue;

import lombok.RequiredArgsConstructor;
import org.community.post.repository.entity.post.PostEntity;
import org.community.post.repository.entity.post.UserPostQueueEntity;
import org.community.post.repository.jpa.JpaPostRepository;
import org.community.post.repository.jpa.JpaUserPostQueueRepository;
import org.community.user.repository.entity.UserEntity;
import org.community.user.repository.jpa.JpaUserRelationRepository;
import org.community.user.repository.jpa.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserPostQueueCommandRepositoryImpl implements UserPostQueueCommandRepository{

    private final JpaPostRepository jpaPostRepository;
    private final JpaUserRelationRepository jpaUserRelationRepository;
    private final JpaUserPostQueueRepository jpaUserPostQueueRepository;

    public void publishPost(PostEntity postEntity) {
        UserEntity authorEntity = postEntity.getAuthor();
        List<Long> followers = jpaUserRelationRepository.findFollowers(authorEntity.getId());

        List<UserPostQueueEntity> userPostQueueEntities = followers.stream()
                .map(userId -> new UserPostQueueEntity(postEntity.getId(), userId, authorEntity.getId()))
                .toList();

        jpaUserPostQueueRepository.saveAll(userPostQueueEntities);
    }

    public void saveFollowPost(Long userId, Long targetId) {
        List<Long> postIds = jpaPostRepository.findAllPostIdsByAuthorId(targetId);

        List<UserPostQueueEntity> userPostQueueEntities = postIds.stream()
                .map(postId -> new UserPostQueueEntity(postId, userId, targetId))
                .toList();

        jpaUserPostQueueRepository.saveAll(userPostQueueEntities);
    }

    public void deleteUnfollowPost(Long userId, Long targetId) {
        jpaUserPostQueueRepository.deleteAllByUserIdAndAuthorId(userId, targetId);
    }
}
