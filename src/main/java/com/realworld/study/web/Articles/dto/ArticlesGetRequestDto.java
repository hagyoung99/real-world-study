package com.realworld.study.web.Articles.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class ArticlesGetRequestDto {
    private String tag;

    private String author;

    private String favorited;

    private int limit;

    private int offset;

    @Builder
    public ArticlesGetRequestDto(String tag, String author, String favorited, int limit, int offset){
        this.tag = tag;
        this.author = author;
        this.favorited = favorited;
        this.limit = (limit == 0) ? 20 : limit;
        this.offset = offset;
    }
}
