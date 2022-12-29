package project.carrot.entity;

import lombok.*;
import project.carrot.global.BaseTime;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTime {
    @Id
    @GeneratedValue
    private Long categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    private String cateName;

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


    public Category(Long categoryId, String cateName) {
        this.categoryId = categoryId;
        this.cateName = cateName;
    }

}
