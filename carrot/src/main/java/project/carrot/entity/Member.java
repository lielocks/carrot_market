package project.carrot.entity;

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
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String pic;

    private String nickname;

    private String email;
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

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPwd(String password) {
        this.pwd = password;
    }
    public void setRoles(List roles) { this.roles = roles; }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
