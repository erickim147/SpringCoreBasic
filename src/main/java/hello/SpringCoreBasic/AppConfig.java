package hello.SpringCoreBasic;

import hello.SpringCoreBasic.member.MemberService;
import hello.SpringCoreBasic.member.MemberServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl();
    }

}
