package org.community.post;

import org.community.common.domain.PositiveIntegerCounter;
import org.community.post.domain.content.PostContent;
import org.community.post.domain.content.PostPublicationState;
import org.community.user.domain.User;

public class Post {

    private final User author;
    private final long userId;
    private final PostContent content;
    private final PositiveIntegerCounter likeCount;
    private PostPublicationState state;

    public Post(PostContent content, User author, long userId) {
        if(author == null) {
            throw new IllegalArgumentException();
        }

        this.content = content;
        this.userId = userId;
        this.author = author;
        this.likeCount = new PositiveIntegerCounter();
        this.state = PostPublicationState.PUBLIC;
    }

    public void like(User user){
        likeCount.increase();
    }

    public void unlike(){
        likeCount.decrease();
    }

    public void updatePost(User user, String updateContent, PostPublicationState state) {
        this.content.updateContent(updateContent);
        this.state = state;
    }
}
