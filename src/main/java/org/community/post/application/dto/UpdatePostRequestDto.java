package org.community.post.application.dto;

import org.community.post.domain.content.Content;
import org.community.post.domain.content.PostPublicationState;

public record UpdatePostRequestDto(Long id, Long userId, String content, PostPublicationState state) {
}
