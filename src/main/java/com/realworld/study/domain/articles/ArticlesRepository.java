package com.realworld.study.domain.articles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles, Long>, CustomArticleRepository {
    Optional<Articles> findBySlug(String slug);

    void deleteBySlug(String slug);
}
