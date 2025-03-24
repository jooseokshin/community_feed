package org.community.post.application.dto;

import org.community.post.domain.content.PostPublicationState;

public record CreatePostRequestDto(Long id, String content, PostPublicationState state) {
}
