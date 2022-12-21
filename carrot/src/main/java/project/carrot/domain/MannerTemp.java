package project.carrot.domain;

import lombok.Getter;
import project.carrot.global.BaseTime;

import javax.persistence.*;

@Entity
@Getter
public class MannerTemp extends BaseTime {
    @Id @GeneratedValue
    private Long mannerTempId;

    @OneToOne(mappedBy = "mannerTemp")
    private Member member;
}
