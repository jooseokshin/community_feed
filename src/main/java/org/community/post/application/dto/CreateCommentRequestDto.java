package org.community.post.application.dto;

public record CreateCommentRequestDto (Long postId, Long userId, String comment) {
}
