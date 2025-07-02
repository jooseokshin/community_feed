package org.community.post.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.community.post.Post;
import org.community.post.application.interfaces.PostRepository;
import org.community.post.repository.entity.post.PostEntity;
import org.community.post.repository.entity.post.QPostEntity;
import org.community.post.repository.jpa.JpaPostRepository;
import org.community.post.repository.post_queue.UserPostQueueCommandRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;
    private final UserPostQueueCommandRepository queueRepository;

    @Override
    public Post findById(Long id) {
        PostEntity postEntity = jpaPostRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
        return postEntity.toPost();
    }

    @Override
    @Transactional
    public Post save(Post post) {
        PostEntity postEntity = jpaPostRepository.save(new PostEntity(post));
        return postEntity.toPost();
    }

    @Override
    public Post publish(Post post) {
        PostEntity postEntity = jpaPostRepository.save(new PostEntity(post));
        queueRepository.publishPost(postEntity);
        return postEntity.toPost();
    }
}
