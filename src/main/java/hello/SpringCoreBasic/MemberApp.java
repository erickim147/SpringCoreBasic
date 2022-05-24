package hello.SpringCoreBasic;

import hello.SpringCoreBasic.member.Grade;
import hello.SpringCoreBasic.member.Member;
import hello.SpringCoreBasic.member.MemberService;
import hello.SpringCoreBasic.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MemberApp {

    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        //MemberService memberService = new MemberServiceImpl();

        ApplicationContext appplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = appplicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        // ctrl + Alt + v = 변수 자동 완성 단축키
        Member findMember = memberService.findMember(1L);

        // soutv -> System.out.println 변수 선택 단축키
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());


    }
}
