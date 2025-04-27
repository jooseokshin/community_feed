package org.community.post.repository.entity.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.community.common.domain.PositiveIntegerCounter;
import org.community.post.domain.comment.Comment;
import org.community.post.domain.content.CommentContent;
import org.community.post.repository.entity.post.PostEntity;
import org.community.user.repository.entity.UserEntity;

@Entity
@Table(name = "community_comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private UserEntity author;

    @ManyToOne
    @JoinColumn(name = "postId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private PostEntity post;

    private String content;
    private Integer likeCounter;

    public CommentEntity(Comment comment) {
        this.id = comment.getId();
        this.author = new UserEntity(comment.getAuthor());
        this.post = new PostEntity(comment.getPost());
        this.content = comment.getContent();
        this.likeCounter = comment.getLikeCount();
    }

    public Comment toComment() {
        return Comment.builder()
                .id(id)
                .author(author.toUser())
                .post(post.toPost())
                .content(new CommentContent(content))
                .likeCount(new PositiveIntegerCounter(likeCounter))
                .build();
    }
}
