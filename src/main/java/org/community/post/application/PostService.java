package org.community.post.application;

import org.community.post.Post;
import org.community.post.application.interfaces.LikeRepository;
import org.community.post.application.interfaces.PostRepository;
import org.community.post.application.dto.CreatePostRequestDto;
import org.community.post.application.dto.LikeRequestDto;
import org.community.post.application.dto.UpdatePostRequestDto;
import org.community.user.application.UserService;
import org.community.user.domain.User;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    public PostService(LikeRepository likeRepository, PostRepository postRepository, UserService userService) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Post getPost(Long id) {
        return postRepository.findById(id);
    }

    public Post createPost(CreatePostRequestDto dto) {
        User author = userService.getUser(dto.postId());
        Post post = Post.createPost(dto.postId(), author, dto.content(), dto.state());
        return postRepository.save(post);
    }

    public Post updatePost(Long id, UpdatePostRequestDto dto) {
        Post post = getPost(id);
        User user = userService.getUser(dto.userId());

        post.updateContent(user, dto.content(), dto.state());
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
