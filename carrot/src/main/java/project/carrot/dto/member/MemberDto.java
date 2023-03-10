package project.carrot.dto.member;

import lombok.*;

public class MemberDto {

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MemberPostDto {
        private String nickname;
        private String email;
        private String pwd;
        private String phone;
        private String username;

    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MemberPatchDto {
        private String nickname;
        private String pwd;
        private String phone;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MyPageMemberInfoDto {
        private String nickname;
        private String pic;
        private String pwd;
        private String phone;
    }

    @Getter
    @Builder
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private Long memberId;
        private String email;
        private String phone;
        private String nickname;
        private String username;

    }

}
