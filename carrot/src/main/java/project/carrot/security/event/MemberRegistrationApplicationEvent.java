package project.carrot.security.event;

import lombok.Getter;
import project.carrot.entity.Member;

@Getter
public class MemberRegistrationApplicationEvent {

    private Member member;

    public MemberRegistrationApplicationEvent(Member member) {
        this.member = member;
    }
}
