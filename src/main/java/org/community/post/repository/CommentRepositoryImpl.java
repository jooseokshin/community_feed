package org.community.post.repository;

import lombok.RequiredArgsConstructor;
import org.community.post.Post;
import org.community.post.application.interfaces.CommentRepository;
import org.community.post.domain.comment.Comment;
import org.community.post.repository.entity.comment.CommentEntity;
import org.community.post.repository.jpa.JpaCommentRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    private final JpaCommentRepository jpaCommentRepository;

    @Override
    public Comment save(Comment comment) {
        Post targetPost = comment.getPost();
        CommentEntity commentEntity = new CommentEntity(comment);
//        if(comment.getId() == null) {
//            jpaCommentRepository.updateCommentEntity(commentEntity);
//        }

        commentEntity = jpaCommentRepository.save(commentEntity);
        return commentEntity.toComment();
    }

    @Override
    public Comment findById(Long id) {
        CommentEntity commentEntity = jpaCommentRepository.findById(id).orElseThrow();
        return commentEntity.toComment();
    }
}
