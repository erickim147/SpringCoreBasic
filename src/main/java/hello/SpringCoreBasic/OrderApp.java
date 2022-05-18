package hello.SpringCoreBasic;

import hello.SpringCoreBasic.Order.Order;
import hello.SpringCoreBasic.Order.OrderService;
import hello.SpringCoreBasic.Order.OrderServiceImpl;
import hello.SpringCoreBasic.member.Grade;
import hello.SpringCoreBasic.member.Member;
import hello.SpringCoreBasic.member.MemberService;
import hello.SpringCoreBasic.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.caculatePrice = " + order.caculatePrice());
    }
}
