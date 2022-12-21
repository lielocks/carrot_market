package project.carrot.domain;

import lombok.Getter;
import project.carrot.global.BaseTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Category extends BaseTime {
    @Id
    @GeneratedValue
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    private String cateName;

    public Category() {

    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


    public Category(Long categoryId, String cateName) {
        this.categoryId = categoryId;
        this.cateName = cateName;
    }

}
