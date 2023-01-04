package project.carrot.repository.member;

import org.springframework.data.jpa.repository.JpaRepository;
import project.carrot.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Optional<Member> findByUsername(String username);
}
