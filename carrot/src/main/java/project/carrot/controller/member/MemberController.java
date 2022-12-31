package project.carrot.controller.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import project.carrot.entity.Member;
import project.carrot.dto.member.MemberDto;
import project.carrot.global.dto.SingleResponseDto;
import project.carrot.mapper.MemberMapper;
import project.carrot.service.member.MemberService;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @PostMapping
    public ResponseEntity postMember(@RequestBody @Valid MemberDto.MemberPostDto memberPostDto) {

        Member member = memberMapper.MemberPostDtoToEntity(memberPostDto);
        MemberDto.Response response = memberService.createMember(member);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity updateMember(@RequestBody @Valid MemberDto.MemberPatchDto memberPatchDto,
                                       @PathVariable Long memberId) {

        Member member = memberMapper.MemberPatchDtoToEntity(memberPatchDto, memberId);
        Member updateMember = memberService.updateMember(member);

        return new ResponseEntity<>(new SingleResponseDto<>(updateMember), HttpStatus.OK);
    }
}
