package org.community.post.application.dto;

public record UpdateCommentRequsetDto(Long commnetId, Long userId, String comment) {
}
