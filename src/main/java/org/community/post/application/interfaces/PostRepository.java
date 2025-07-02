package org.community.post.application.interfaces;

import org.community.post.Post;

import java.util.Optional;

public interface PostRepository {

    Post findById(Long id);
    Post save(Post post);
    Post publish(Post post);
}
