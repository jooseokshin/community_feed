package org.community.post.application.interfaces;

import org.community.post.domain.comment.Comment;

import java.util.Optional;

public interface CommentRepository {

    Comment save(Comment comment);

    Comment findById(Long id);
}
