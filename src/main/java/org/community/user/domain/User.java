package org.community.user.domain;

import org.community.common.domain.PositiveIntegerCounter;

import java.util.Objects;

public class User {

    private final Long id;
    private final UserInfo userInfo;
    private final PositiveIntegerCounter followingCount;
    private final PositiveIntegerCounter followerCount;

    public User(Long id, UserInfo userInfo) {
        if(userInfo == null){
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.userInfo = userInfo;
        this.followerCount = new PositiveIntegerCounter();
        this.followingCount = new PositiveIntegerCounter();
    }

    public void follow(User targetUser){
        if(this.equals(targetUser))
            throw new IllegalArgumentException();

        targetUser.followerCount.increase();
        this.followingCount.increase();
    }

    public void unfollow(User targetUser){
        if(this.equals(targetUser))
            throw new IllegalArgumentException();

        targetUser.followerCount.decrease();
        this.followingCount.decrease();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public int getFollowerCount() {
        return followerCount.getCount();
    }

    public int getFollowingCount() {
        return followingCount.getCount();
    }
}
