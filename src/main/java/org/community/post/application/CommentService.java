package org.community.post.application;

import org.community.post.Post;
import org.community.post.application.dto.CreateCommentRequestDto;
import org.community.post.application.dto.LikeRequestDto;
import org.community.post.application.dto.UpdateCommentRequestDto;
import org.community.post.application.interfaces.CommentRepository;
import org.community.post.application.interfaces.LikeRepository;
import org.community.post.domain.comment.Comment;
import org.community.user.application.UserService;
import org.community.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final UserService userService;
    private final PostService postService;
    private final CommentRepository commentRepository;
    private final LikeRepository likeRepository;

    public CommentService(CommentRepository commentRepository, UserService userService, PostService postService, LikeRepository likeRepository) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
        this.likeRepository = likeRepository;
    }

    public Comment getComment(Long id) {
        return commentRepository.findById(id);
    }

    public Comment createComment(CreateCommentRequestDto dto) {
        Post post = postService.getPost(dto.postId());
        User user = userService.getUser(dto.userId());

        Comment comment = Comment.createComment(post, user, dto.comment());
        return commentRepository.save(comment);
    }

    public Comment updateComment(UpdateCommentRequestDto dto) {
        Comment comment = getComment(dto.commentId());
        User user = userService.getUser(dto.userId());

        comment.updateComment(user, dto.comment());
        return commentRepository.save(comment);
    }

    public void likeComment(LikeRequestDto dto){
        Comment comment = getComment(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(comment,user)){
            return;
        }

        comment.like(user);
        likeRepository.like(comment, user);
    }

    public void unlikeComment(LikeRequestDto dto){
        Comment comment = getComment(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(comment,user)){
            comment.unlike();
            likeRepository.unlike(comment, user);
        }
    }
}
