package com.realworld.study.domain.tag;

import com.realworld.study.domain.ArticleTag.TagMapping;
import jakarta.persistence.*;
import lombok.Builder;
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

    @OneToMany(mappedBy = "tags", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TagMapping> tagMappings;
    @Builder
    public Tags(String tagName) {
        this.tagName = tagName;
    }

    public void addTagMapping(List<TagMapping> tagMappings) {
        this.tagMappings = tagMappings;
    }
}
