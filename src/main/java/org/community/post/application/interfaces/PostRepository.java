package org.community.post.application.interfaces;

import org.community.post.Post;

import java.util.Optional;

public interface PostRepository {

    Post save(Post post);

    Optional<Post> findById(Long id);
}
