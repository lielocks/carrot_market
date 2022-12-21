package project.carrot.domain;

import lombok.Builder;
import lombok.Getter;
import project.carrot.global.BaseTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
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

    public Article() {

    }
    public Article(Long articleId) {
        this.articleId = articleId;
    }

    public Article(Long articleId, ItemStatus status, String title, String content, String place, String picture, String price, Integer likeArticle, Member member, List<Category> categoryList) {
        this.articleId = articleId;
        this.status = status;
        this.title = title;
        this.content = content;
        this.place = place;
        this.picture = picture;
        this.price = price;
        this.likeArticle = likeArticle;
        this.member = member;
        this.categoryList = categoryList;
    }
}
