package project.carrot.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.carrot.entity.Member;
import project.carrot.dto.member.MemberDto;
import project.carrot.global.dto.SingleResponseDto;
import project.carrot.mapper.MemberMapper;
import project.carrot.service.member.MemberService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @PostMapping
    public ResponseEntity postMember(@RequestBody MemberDto.MemberPostDto memberPostDto) {

        Member member = memberMapper.MemberPostDtoToEntity(memberPostDto);
        Member createdMember = memberService.createMember(member);
        MemberDto.Response response = memberMapper.MemberToMemberResponse(createdMember);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }
}
