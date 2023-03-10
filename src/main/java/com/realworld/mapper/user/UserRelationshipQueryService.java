package com.realworld.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserRelationshipQueryService {
    boolean isUserFollowing(
            @Param("userId") String userId, @Param("anotherUserId") String anotherUserId
    );

    Set<String> followingAuthors(@Param("userId") String userId, @Param("ids") List<String> ids);

    List<String> followedUsers(@Param("userId") String userId);
}
