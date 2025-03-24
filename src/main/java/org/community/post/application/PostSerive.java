package org.community.post.application;

import org.community.post.Post;
import org.community.post.application.interfaces.LikeRepository;
import org.community.post.application.interfaces.PostRepository;
import org.community.post.application.dto.CreatePostRequestDto;
import org.community.post.application.dto.LikeRequestDto;
import org.community.post.application.dto.UpdatePostRequestDto;
import org.community.user.application.UserService;
import org.community.user.domain.User;

public class PostSerive {

    private final UserService userService;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public PostSerive(LikeRepository likeRepository, PostRepository postRepository, UserService userService) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Post not found"));
    }

    public Post createPost(CreatePostRequestDto dto) {
        User author = userService.getUser(dto.id());
        Post post = Post.createPost(dto.id(), author, dto.content(), dto.state());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, UpdatePostRequestDto dto) {
        Post post = getPost(id);
        User user = userService.getUser(dto.userId());

        post.updatePost(user, dto.content(), dto.state());
        return postRepository.save(post);
    }

    public void likePost(LikeRequestDto dto){
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(post,user)){
            return;
        }

        post.like(user);
        likeRepository.like(post, user);
    }

    public void unlikePost(LikeRequestDto dto){
        Post post = getPost(dto.targetId());
        User user = userService.getUser(dto.userId());

        if(likeRepository.checkLike(post,user)){
            post.unlike();
            likeRepository.unlike(post, user);
        }
    }
}
