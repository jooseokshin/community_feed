package org.community.post.repository.jpa;

import org.community.post.repository.entity.comment.CommentEntity;
import org.community.post.repository.entity.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {

    @Query("SELECT p.id FROM PostEntity p WHERE p.author.id = :authorId")
    List<Long> findAllPostIdsByAuthorId(Long authorId);

//    @Modifying
//    @Query("UPDATE PostEntity p SET p.commentCounter = p.commentCounter + 1 WHERE p.id = :postId")
//    void increaseCommentCounter(Long postId);
}
