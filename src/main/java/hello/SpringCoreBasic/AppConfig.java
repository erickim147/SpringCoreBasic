package hello.SpringCoreBasic;

import hello.SpringCoreBasic.Order.OrderService;
import hello.SpringCoreBasic.Order.OrderServiceImpl;
import hello.SpringCoreBasic.discount.FixDiscountPolicy;
import hello.SpringCoreBasic.member.MemberService;
import hello.SpringCoreBasic.member.MemberServiceImpl;
import hello.SpringCoreBasic.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService(){

        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
