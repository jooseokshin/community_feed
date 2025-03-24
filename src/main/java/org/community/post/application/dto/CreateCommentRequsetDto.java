package org.community.post.application.dto;

public record CreateCommentRequsetDto(Long postId, Long userId, String comment) {
}
