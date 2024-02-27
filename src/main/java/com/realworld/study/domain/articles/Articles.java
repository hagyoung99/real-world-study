package com.realworld.study.domain.articles;

import com.realworld.study.domain.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
@Entity
public class Articles extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String body;

    private String slug;

    private String tag;

    @Builder
    public Articles(String title, String description, String body, String tag) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.slug = title.replaceAll("[!?@$^,. ]", "-");
        this.tag = tag;
    }

    public void updateArticle(String title, String description, String body) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.slug = title.replaceAll("[!?@$^,. ]", "-");
    }
}
