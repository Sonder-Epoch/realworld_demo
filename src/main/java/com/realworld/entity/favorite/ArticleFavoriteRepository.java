package com.realworld.entity.favorite;

import java.util.Optional;

public interface ArticleFavoriteRepository {
    void save(ArticleFavorite articleFavorite);

    Optional<ArticleFavorite> find(String articleId, String userId);

    void remove(ArticleFavorite articleFavorite);
}
