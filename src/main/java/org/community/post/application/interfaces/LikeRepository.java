package org.community.post.application.interfaces;

import org.community.post.Post;
import org.community.post.domain.comment.Comment;
import org.community.user.domain.User;

public interface LikeRepository {

    boolean checkLike(Post post, User user);

    void like(Post post, User user);

    void unlike(Post post, User user);

    boolean checkLike(Comment comment, User user);

    void like(Comment comment, User user);

    void unlike(Comment comment, User user);
}
