package project.carrot.entity;

import lombok.*;
import project.carrot.entity.enums.ItemStatus;
import project.carrot.global.BaseTime;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article extends BaseTime {

    @Id @GeneratedValue
    private Long articleId;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    private String title;

    private String content;
    private String place;
    private String picture;

    private String price;
    private Integer likeArticle;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    public Article(Long articleId) {
        this.articleId = articleId;
    }

}
