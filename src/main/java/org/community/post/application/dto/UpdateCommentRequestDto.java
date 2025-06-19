package org.community.post.application.dto;

public record UpdateCommentRequestDto(Long commentId, Long userId, String comment) {
}
