package com.realworld.study.domain.articles;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.realworld.study.web.Articles.dto.ArticlesGetRequestDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static org.springframework.util.StringUtils.hasText;

@RequiredArgsConstructor
public class CustomArticleRepositoryImpl implements CustomArticleRepository {

    private final JPAQueryFactory queryFactory;
    @Override
    public List<Articles> findArticlesByParam(ArticlesGetRequestDto requestDto) {
        QArticles articles = QArticles.articles;
        return queryFactory.selectFrom(articles)
                .where(
                    tagLike(articles, requestDto.getTag())
                )
                .limit(requestDto.getLimit())
                .offset(requestDto.getOffset())
                .fetch();
    }

    private BooleanExpression tagLike(QArticles articles, String tag) {
        return hasText(tag) ? articles.tag.contains(tag) : null;
    }

//    private BooleanExpression authorEq(QArticles articles, String author) {
//        return hasText(author) ?
//    }

}
