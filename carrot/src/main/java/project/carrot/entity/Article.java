package project.carrot.domain;

import lombok.*;
import project.carrot.global.BaseTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Category> categoryList = new ArrayList<>();

    public Article(Long articleId) {
        this.articleId = articleId;
    }

}
