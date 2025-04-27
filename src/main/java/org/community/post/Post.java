package org.community.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.community.common.domain.PositiveIntegerCounter;
import org.community.post.domain.content.Content;
import org.community.post.domain.content.PostContent;
import org.community.post.domain.content.PostPublicationState;
import org.community.user.domain.User;

@Builder
@AllArgsConstructor
@Getter
public class Post {

    private final User author;
    private final long id;
    private final Content content;
    private final PositiveIntegerCounter likeCount;
    private PostPublicationState state;

    public static Post createPost(Long id, User author, String content, PostPublicationState state) {
        return new Post(id, author, new PostContent(content), state);
    }

    public static Post createDefaultPost(Long id, User author, String content) {
        return new Post(id, author, new PostContent(content), PostPublicationState.PUBLIC);
    }

    public Post(Long id, User author, Content content) {
        this(id, author, content, PostPublicationState.PUBLIC);
    }

    public Post(Long id, User author, Content content, PostPublicationState state) {
        if(author == null) {
            throw new IllegalArgumentException();
        }

        this.content = content;
        this.id = id;
        this.author = author;
        this.likeCount = new PositiveIntegerCounter();
        this.state = state;
    }

    public int getLikeCount() {
        return likeCount.getCount();
    }

    public String getContent() {
        return content.getContentText();
    }

    public void like(User user){
        if(this.author.equals(user)){
            throw new IllegalArgumentException();
        }
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
