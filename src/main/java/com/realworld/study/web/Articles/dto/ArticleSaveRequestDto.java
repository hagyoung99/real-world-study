package com.realworld.study.web.Articles.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.realworld.study.domain.articles.Articles;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@NoArgsConstructor
public class ArticleSaveRequestDto {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("body")
    private String body;

    @JsonProperty("tagList")
    private ArrayList<String> tagList;

    @Builder
    public ArticleSaveRequestDto(String title, String description, String body, ArrayList<String> tagList){
        this.title = title;
        this.description = description;
        this.body = body;
        this.tagList = tagList;
    }

    public Articles toEntity(){
        return Articles.builder()
                .title(title)
                .description(description)
                .body(body)
                .tag(String.join(",", tagList))
                .build();
    }
}
