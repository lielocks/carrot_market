package project.carrot.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;
import project.carrot.global.BaseTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Transactional
public class ChatRoom extends BaseTime {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // chatroom_member

    // idx(pk), roomId, memberId

    // 1    1       2
    //  1   1       3

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String roomId;
    @Column
    private String title;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "USER_LIST",
            joinColumns = @JoinColumn(name = "room_id"))
    List<String> userlist = new ArrayList<>();

    public enum Onair {
        ON, OFF;

        @Getter
        private String onair;
    }

    @Builder
    public ChatRoom(String roomId, String title, String pwd) {
        this.roomId = roomId;
        this.title = title;
    }

}

