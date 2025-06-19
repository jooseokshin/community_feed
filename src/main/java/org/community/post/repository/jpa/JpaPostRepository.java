package org.community.post.repository.jpa;

import org.community.post.repository.entity.comment.CommentEntity;
import org.community.post.repository.entity.post.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JpaPostRepository extends JpaRepository<PostEntity, Long> {

//    @Query("SELECT p.id FROM PostEntity p WHERE p.author.id = :authorId")
//    List<Long> findAllPostIdsByAuthorId(Long authorId);
//
//    @Modifying
//    @Query("UPDATE PostEntity p SET p.commentCounter = p.commentCounter + 1 WHERE p.id = :postId")
//    void increaseCommentCounter(Long postId);

//    @Modifying
//    @Query(value = "UPDATE PostEntity p "
//            + "SET p.content = :#{#commentEntity.content}, p.state = :#{commentEntity.state}, p.updDt = now() "
//            + "WHERE p.id = :#{#commentEntity.getId()}")
//    void updateCommentEntity(CommentEntity commentEntity);
//
//    @Modifying
//    @Query(value = "UPDATE CommentEntity c "
//            + "SET c.likeCount = :#{#commentEntity.likeCount}, c.updDt = now() "
//            + "WHERE c.id = :#{#commentEntity.getId()}")
//    void updateLikeCount(CommentEntity commentEntity);
}
