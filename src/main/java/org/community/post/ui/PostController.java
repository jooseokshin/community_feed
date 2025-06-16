package org.community.post.ui;

import lombok.RequiredArgsConstructor;
import org.community.common.ui.Response;
import org.community.post.Post;
import org.community.post.application.PostService;
import org.community.post.application.dto.CreatePostRequestDto;
import org.community.post.application.dto.LikeRequestDto;
import org.community.post.application.dto.UpdatePostRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public Response<Long> createPost(@RequestBody CreatePostRequestDto dto) {
        Post post = postService.createPost(dto);
        return Response.ok(post.getId());
    }

    @PatchMapping("{postId}")
    public Response<Long> updatePost(@PathVariable(name = "postId") Long postId, UpdatePostRequestDto dto) {
        Post post = postService.updatePost(postId, dto);
        return Response.ok(post.getId());
    }

    @PostMapping("/like")
    public Response<Void> likePost(@RequestBody LikeRequestDto dto) {
        postService.likePost(dto);
        return Response.ok(null);
    }

    @PostMapping("/unlike")
    public Response<Void> unlikePost(@RequestBody LikeRequestDto dto) {
        postService.unlikePost(dto);
        return Response.ok(null);
    }
}
