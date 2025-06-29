package org.community.post.repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.community.post.Post;
import org.community.post.application.interfaces.PostRepository;
import org.community.post.repository.entity.post.PostEntity;
import org.community.post.repository.entity.post.QPostEntity;
import org.community.post.repository.jpa.JpaPostRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    private final JpaPostRepository jpaPostRepository;

    @Override
    @Transactional
    public Post save(Post post) {
        PostEntity postEntity = new PostEntity(post);
//        if(postEntity.getId() != null){
//            jpaPostRepository.updatePostEntity(postEntity);
//            return postEntity.toPost();
//        }

        postEntity = jpaPostRepository.save(postEntity);
        return postEntity.toPost();
    }

    @Override
    public Post findById(Long id) {
        PostEntity postEntity = jpaPostRepository.findById(id).orElseThrow();
        return postEntity.toPost();
    }
}
