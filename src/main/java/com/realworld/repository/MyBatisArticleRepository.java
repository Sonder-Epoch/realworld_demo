package com.realworld.repository;

import com.realworld.entity.article.Article;
import com.realworld.entity.article.ArticleRepository;
import com.realworld.entity.article.Tag;
import com.realworld.mapper.article.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public class MyBatisArticleRepository implements ArticleRepository {
    private final ArticleMapper articleMapper;

    @Autowired
    public MyBatisArticleRepository(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    @Transactional
    public void save(Article article) {
        if (articleMapper.findById(article.getId()) == null) {
            createNew(article);
        } else {
            articleMapper.update(article);
        }
    }

    private void createNew(Article article) {
        for (Tag tag : article.getTags()) {
            Tag targetTag =
                    Optional.ofNullable(articleMapper.findTag(tag.getName()))
                            .orElseGet(
                                    () -> {
                                        articleMapper.insertTag(tag);
                                        return tag;
                                    }
                            );
            articleMapper.insertArticleTagRelation(article.getId(), targetTag.getId());
        }
        articleMapper.insert(article);
    }

    @Override
    public Optional<Article> findById(String id) {
        return Optional.ofNullable(articleMapper.findById(id));
    }

    @Override
    public Optional<Article> findBySlug(String slug) {
        return Optional.ofNullable(articleMapper.findBySlug(slug));
    }

    @Override
    public void remove(Article article) {
        articleMapper.delete(article.getId());
    }
}
