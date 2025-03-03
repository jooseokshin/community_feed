package org.community.post;

import org.practice.post.domain.content.PostContent;
import org.practice.user.domain.User;

public class Post {

    private final User author;
    private final long userId;
    private final PostContent content;

    public Post(PostContent content, User author, long userId) {
        if(author == null) throw new IllegalArgumentException();

        this.content = content;
        this.userId = userId;
        this.author = author;
    }
}
