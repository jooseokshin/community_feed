package org.community.post.application;

import org.community.post.Post;
import org.community.post.application.interfaces.PostRepository;
import org.community.post.application.interfaces.dto.CreatePostRequestDto;
import org.community.post.domain.content.Content;
import org.community.post.domain.content.PostContent;
import org.community.user.application.UserService;
import org.community.user.domain.User;

public class PosertSerive {

    private final UserService userService;
    private final PostRepository postRepository;

    public PosertSerive(UserService userService, PostRepository postRepository) {
        this.userService = userService;
        this.postRepository = postRepository;
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    public Post createPost(CreatePostRequestDto dto) {
        User author = userService.getUser(dto.id());
        Post post = Post.createPost(dto.id(), author, dto.content(), dto.state());
        return postRepository.save(post);
    }
}
