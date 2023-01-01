package project.carrot.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import project.carrot.config.SecurityTestConfig;
import project.carrot.controller.member.MemberController;
import project.carrot.dto.member.MemberDto;
import project.carrot.entity.Member;
import project.carrot.mapper.MemberMapper;
import project.carrot.service.member.MemberService;
import com.google.gson.Gson;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MemberController.class)
@Import(SecurityTestConfig.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com") // (1)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private Gson gson;

    @MockBean
    private MemberService memberService;

    @Test
    @DisplayName("멤버가 잘 생성되면 200 OK를 반환한다.")
    public void create() throws Exception {

        //given
        MemberDto.MemberPostDto post = MemberDto.MemberPostDto.builder()
                .username("민수")
                .nickname("민순")
                .email("f@gmail.com")
                .phone("010-1234-5678")
                .build();

        Member member = memberMapper.MemberPostDtoToEntity(post);
        member.setMemberId(1L);

        given(memberService.createMember(Mockito.any(Member.class)))
                .willReturn(memberMapper.MemberToMemberSimpleResponse(member));

        String content = gson.toJson(post);

        //when
        ResultActions actions =
                mockMvc.perform(
                        post("/members")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        //then
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/members/"))));
    }
}