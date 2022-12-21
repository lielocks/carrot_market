package project.carrot.domain;

import lombok.Getter;
import project.carrot.global.BaseTime;

import javax.persistence.*;

@Entity
@Getter
public class BookMark extends BaseTime {

    @Id @GeneratedValue
    private Long bookMarkId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


}
