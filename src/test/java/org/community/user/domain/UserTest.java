package org.community.user.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private final UserInfo userInfo = new UserInfo("test","");
    private User user1;
    private User user2;

    @BeforeEach
    void init() {
        user1 = new User(1L, userInfo);
        user2 = new User(2L, userInfo);
    }

    @Test
    void givenTwoUser_whenEqual_thenReturnFalse() {
        // given
        boolean isSame = user1.equals(user2);

        //then
        assertFalse(isSame);
    }

    @Test
    void givenSameIdUser_whenEqual_thenReturnTrue() {
        // given
        User testUser = new User(1L, userInfo);

        //when
        boolean isSame = testUser.equals(user1);

        //then
        assert(isSame);
    }

    @Test
    void givenTwoUser_whenHashCode_thenReturnFalse() {
        // given
        int hashCode1 = user1.hashCode();
        int hashCode2 = user2.hashCode();

        //then
        assertNotEquals(hashCode1, hashCode2);
    }

    @Test
    void givenTwoUser_whenUser1FollowUser2_thenIncreaseUserCount() {
        // when
        user1.follow(user2);

        // then
        assertEquals(1, user1.getFollowingCount());
        assertEquals(0, user1.getFollowerCount());
        assertEquals(1, user2.getFollowerCount());
        assertEquals(0, user2.getFollowingCount());
    }
}
