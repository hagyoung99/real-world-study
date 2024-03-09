package com.realworld.study.domain.ArticleTag;
import com.realworld.study.domain.articles.Articles;
import com.realworld.study.domain.tag.Tags;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
public class ArticleTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleTagId;

    @Setter
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Articles article;


    @Setter
    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private Tags tag;

    public ArticleTag(Articles article, Tags tag){
        this.article = article;
        this.tag = tag;
    }

}
