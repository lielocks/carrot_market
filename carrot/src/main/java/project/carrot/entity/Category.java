package project.carrot.entity;

import lombok.*;
import project.carrot.entity.enums.CategoryName;
import project.carrot.global.BaseTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTime {
    @Id
    @GeneratedValue
    private Long categoryId;

    @OneToMany(mappedBy = "category")
    @Builder.Default
    private List<Article> articleList = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }


}
