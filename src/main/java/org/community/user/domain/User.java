package org.community.user.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.community.common.domain.PositiveIntegerCounter;

import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    @Id
    private Long id;
    private UserInfo userInfo;
    private PositiveIntegerCounter followingCount;
    private PositiveIntegerCounter followerCount;

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

    public int followerCount() {
        return followerCount.getCount();
    }

    public int followingCount() {
        return followingCount.getCount();
    }

    public String getProfileImage() {
        return userInfo.getProfileImageUrl();
    }

    public String getName() {
        return userInfo.getName();
    }
}
