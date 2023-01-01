package project.carrot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import project.carrot.entity.Member;
import project.carrot.dto.member.MemberDto;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member MemberPostDtoToEntity(MemberDto.MemberPostDto requestBody);
    MemberDto.Response MemberToMemberSimpleResponse(Member member);

    default Member MemberPatchDtoToEntity(MemberDto.MemberPatchDto updateMember, Long memberId) {
        return Member.builder()
                .memberId(memberId)
                .nickname(updateMember.getNickname())
                .pwd(updateMember.getPwd())
                .phone(updateMember.getPhone())
                .build();
    }
}
