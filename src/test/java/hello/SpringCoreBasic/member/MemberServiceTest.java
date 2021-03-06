package hello.SpringCoreBasic.member;

import hello.SpringCoreBasic.AppConfig;
import hello.SpringCoreBasic.member.Grade;
import hello.SpringCoreBasic.member.Member;
import hello.SpringCoreBasic.member.MemberService;
import hello.SpringCoreBasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        // 변수 member와 findMember로 찾은 변수 findMember가 같은지 비교
        Assertions.assertThat(member).isEqualTo(findMember);



    }

}
