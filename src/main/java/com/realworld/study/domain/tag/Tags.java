package com.realworld.study.domain.tag;

import com.realworld.study.domain.ArticleTag.ArticleTag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.swing.text.html.HTML;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    private String tagName;

    @OneToMany(mappedBy = "articleTag")
    private List<ArticleTag> articleTagList = new ArrayList<ArticleTag>();

    public Tags(String tagName){
        this.tagName = tagName;
    }

    public void addArticleTag(ArticleTag articleTag) {
        this.articleTagList.add(articleTag);
        if(articleTag.getTag() != this) {
            articleTag.setTag(this);
        }
    }
}
