package org.community.post.ui;

import lombok.RequiredArgsConstructor;
import org.community.common.ui.Response;
import org.community.post.application.CommentService;
import org.community.post.application.dto.CreateCommentRequestDto;
import org.community.post.application.dto.LikeRequestDto;
import org.community.post.application.dto.UpdateCommentRequestDto;
import org.community.post.domain.comment.Comment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/commnet")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
//    private final CommentQueryRepositoryImpl commentQueryRepository;

    @PostMapping
    public Response<Long> createComment(@RequestBody CreateCommentRequestDto dto) {
        Comment comment = commentService.createComment(dto);
        return Response.ok(comment.getId());
    }

    @PatchMapping
    public Response<Long> updateComment(@RequestBody UpdateCommentRequestDto dto) {
        Comment comment = commentService.updateComment(dto);
        return Response.ok(comment.getId());
    }

    @PostMapping("/like")
    public Response<Void> likeComment(@RequestBody LikeRequestDto dto) {
        commentService.likeComment(dto);
        return Response.ok(null);
    }

    @PostMapping("/unlike")
    public Response<Void> unlikeComment(@RequestBody LikeRequestDto dto) {
        commentService.unlikeComment(dto);
        return Response.ok(null);
    }

//    @GetMapping("/post/{postId}")
//    public Response<List<GetContentResponseDto>> getCommentList(@PathVariable(name = "postId") Long postId, Long userId, Long lastCommentId) {
//        List<GetContentResponseDto> commentList = commentQueryRepository.getCommentList(postId, userId, lastCommentId);
//        return Response.ok(commentList);
//    }
}
