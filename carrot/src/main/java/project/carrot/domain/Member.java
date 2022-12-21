package project.carrot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import project.carrot.global.BaseTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseTime {

    @Id
    @GeneratedValue
    private Long memberId;

    private String pic;

    private String nickname;

    private String email;

    private String id;
    private String pwd;
    private String phone;
    private String username;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<BookMark> bookMarks = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "mannerTemp_id")
    private MannerTemp mannerTemp;

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
}
