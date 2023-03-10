package com.realworld.entity.comment;

import cn.hutool.core.date.DateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comment {
    private String id;
    private String body;
    private String userId;
    private String articleId;
    private DateTime createdAt;

    public Comment(String body, String userId, String articleId){
        this.id = UUID.randomUUID().toString();
        this.body = body;
        this.articleId = articleId;
        this.userId = userId;
        this.createdAt = new DateTime();
    }
}
