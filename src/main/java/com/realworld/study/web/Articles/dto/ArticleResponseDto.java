package com.realworld.study.web.Articles.dto;

import com.realworld.study.domain.articles.Articles;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class ArticleResponseDto {
    private String slug;
    private String title;
    private String description;
    private String body;
    private String[] tagList;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ArticleResponseDto(Articles entity) {
        this.slug = entity.getSlug() + "-" + entity.getArticleId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.body = entity.getBody();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getCreatedAt();
    }
}
