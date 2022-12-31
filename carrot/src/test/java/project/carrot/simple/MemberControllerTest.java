package project.carrot.simple;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import project.carrot.config.SecurityTestConfig;
import project.carrot.controller.member.MemberController;
import project.carrot.dto.member.MemberDto;
import project.carrot.service.member.MemberService;

import static org.hamcrest.Matchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

@RunWith(SpringRunner.class)
@WebMvcTest(MemberController.class)
@Import(SecurityTestConfig.class)
@AutoConfigureRestDocs(uriScheme = "https", uriHost = "docs.api.com") // (1)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private MemberService memberService;

    @Test
    public void create() throws Exception {

        //given
        MemberDto.Response response = MemberDto.Response.builder()
                .memberId(1L)
                .username("호석")
                .nickname("이")
                .email("ffff")
                .phone("ff")
                .build();

        given(memberService.createMember(eq(1L), any(PersonDto.Update.class)))
                .willReturn(response); // (3)

        //when
        MemberDto.MemberPostDto memberPostDto = new MemberDto.MemberPostDto();
        update.setFirstName("호석");
        update.setLastName("이");
        update.setBirthDate(LocalDate.of(1985, 2, 1));

        ResultActions result = this.mockMvc.perform(
                put("/persons/", 1L)
                        .content(objectMapper.writeValueAsString(update))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        );

        //then
        result.andExpect(status().isOk())
                .andDo(document("persons-update", // (4)
                        getDocumentRequest(),
                        getDocumentResponse(),
                        pathParameters(
                                parameterWithName("id").description("아이디")
                        ),
                        requestFields(
                                fieldWithPath("firstName").type(JsonFieldType.STRING).description("이름"),
                                fieldWithPath("lastName").type(JsonFieldType.STRING).description("성"),
                                fieldWithPath("birthDate").type(JsonFieldType.STRING).description("생년월일"),
                                fieldWithPath("hobby").type(JsonFieldType.STRING).description("취미")
                        ),
                        responseFields(
                                fieldWithPath("code").type(JsonFieldType.STRING).description("결과코드"),
                                fieldWithPath("message").type(JsonFieldType.STRING).description("결과메시지"),
                                fieldWithPath("data.person.id").type(JsonFieldType.NUMBER).description("아이디"),
                                fieldWithPath("data.person.firstName").type(JsonFieldType.STRING).description("이름"),
                                fieldWithPath("data.person.lastName").type(JsonFieldType.STRING).description("성"),
                                fieldWithPath("data.person.age").type(JsonFieldType.NUMBER).description("나이"),
                                fieldWithPath("data.person.birthDate").type(JsonFieldType.STRING).description("생년월일"),
                                fieldWithPath("data.person.gender").type(JsonFieldType.STRING).description("성별"),
                                fieldWithPath("data.person.hobby").type(JsonFieldType.STRING).description("취미")
                        )
                ));
    }
}