package org.community.post.repository;

import org.community.post.Post;
import org.community.post.application.interfaces.LikeRepository;
import org.community.post.domain.comment.Comment;
import org.community.user.domain.User;

public class LikeRepositoryImpl implements LikeRepository {
    @Override
    public boolean checkLike(Post post, User user) {
        return false;
    }

    @Override
    public void like(Post post, User user) {

    }

    @Override
    public void unlike(Post post, User user) {

    }

    @Override
    public boolean checkLike(Comment comment, User user) {
        return false;
    }

    @Override
    public void like(Comment comment, User user) {

    }

    @Override
    public void unlike(Comment comment, User user) {

    }
}
