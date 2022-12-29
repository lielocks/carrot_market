package project.carrot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import project.carrot.entity.Member;
import project.carrot.dto.member.MemberDto;

@Mapper(componentModel = "spring", typeConversionPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    Member MemberPostDtoToEntity(MemberDto.MemberPostDto requestBody);
    MemberDto.Response MemberToMemberResponse(Member member);
}
