package com.realworld.study.service;

import com.realworld.study.domain.articles.Articles;
import com.realworld.study.domain.articles.ArticlesRepository;
import com.realworld.study.web.Articles.dto.ArticleResponseDto;
import com.realworld.study.web.Articles.dto.ArticleSaveRequestDto;
import com.realworld.study.web.Articles.dto.ArticlesGetRequestDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticlesService {
    private final ArticlesRepository articlesRepository;

    @Transactional
    public ArticleResponseDto saveArticle(ArticleSaveRequestDto requestDto){
        Articles article = articlesRepository.save(requestDto.toEntity());
        return new ArticleResponseDto(article);
    }

    public ArticleResponseDto findArticleBySlug(String slug) {
        Articles articles = articlesRepository.findBySlug(slug)
                .orElseThrow(() -> new IllegalArgumentException("해당 아티클이 없습니다. slug = " + slug));
        return new ArticleResponseDto(articles);
    }

    public List<ArticleResponseDto> findArticlesByParam(ArticlesGetRequestDto requestDto){
        return articlesRepository.findArticlesByParam(requestDto).stream()
                .map(ArticleResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ArticleResponseDto updateArticle(String slug, ArticleSaveRequestDto requestDto) {
        Articles articles = articlesRepository.findBySlug(slug)
                .orElseThrow(() -> new IllegalArgumentException("해당 아티클이 없습니다. slug = " + slug));

        String title = Optional.ofNullable(requestDto.getTitle()).orElse(articles.getTitle());
        String description = Optional.ofNullable(requestDto.getDescription()).orElse(articles.getDescription());
        String body = Optional.ofNullable(requestDto.getBody()).orElse(articles.getBody());

        articles.updateArticle(title, description, body);
        return new ArticleResponseDto(articles);
    }

    @Transactional
    public void deleteArticle(String slug) {
        articlesRepository.deleteBySlug(slug);
    }
}
