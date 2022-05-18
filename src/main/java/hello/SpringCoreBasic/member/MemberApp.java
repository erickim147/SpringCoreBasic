package hello.SpringCoreBasic.member;

import java.util.Arrays;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // ctrl + Alt + v = 변수 자동 완성 단축키
        Member findMember = memberService.findMember(1L);

        // soutv -> System.out.println 변수 선택 단축키
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
