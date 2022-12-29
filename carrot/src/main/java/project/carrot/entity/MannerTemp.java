package project.carrot.domain;

import lombok.*;
import project.carrot.global.BaseTime;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MannerTemp extends BaseTime {
    @Id @GeneratedValue
    private Long mannerTempId;

    @OneToOne(mappedBy = "mannerTemp")
    private Member member;
}
