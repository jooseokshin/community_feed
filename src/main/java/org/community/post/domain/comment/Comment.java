package org.community.post.domain.comment;

import org.community.common.domain.PositiveIntegerCounter;
import org.community.post.Post;
import org.community.post.domain.content.CommentContent;
import org.community.post.domain.content.Content;
import org.community.user.domain.User;

public class Comment {

    private final Long id;
    private final Post post;
    private final User author;
    private final Content content;
    private final PositiveIntegerCounter likeCount;

    public static Comment createComment(Post post, User author, String content) {
        return new Comment(null, post, author, new CommentContent(content));
    }

    public Comment(Long id, Post post, User author, Content content) {
        if(content == null || post == null || author == null){
            throw new IllegalArgumentException();
        }

        this.content = content;
        this.id = id;
        this.post = post;
        this.author = author;
        this.likeCount = new PositiveIntegerCounter();
    }

    public void like(User user){
        likeCount.increase();
    }

    public void unlike(){
        likeCount.decrease();
    }

    public void updateComment(User user, String updateContent) {
        this.content.updateContent(updateContent);
    }
}
