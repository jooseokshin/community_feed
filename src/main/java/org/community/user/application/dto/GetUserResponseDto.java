package org.community.user.application.dto;

import org.community.user.domain.User;

public record GetUserResponseDto (Long id, String name, String profileImageUrl, Integer followerCount){

    public GetUserResponseDto(User user) {
        this(user.getId(), user.getName(), user.getProfileImage(), user.followerCount());
    }
}
