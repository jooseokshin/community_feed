package org.community.post.repository;

import lombok.RequiredArgsConstructor;
import org.community.post.application.interfaces.CommentRepository;
import org.community.post.domain.comment.Comment;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository {

    @Override
    public Comment save(Comment comment) {
        return null;
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.empty();
    }
}
