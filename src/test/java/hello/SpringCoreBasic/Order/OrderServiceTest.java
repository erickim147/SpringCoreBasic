package hello.SpringCoreBasic.Order;

import hello.SpringCoreBasic.Order.Order;
import hello.SpringCoreBasic.Order.OrderService;
import hello.SpringCoreBasic.Order.OrderServiceImpl;
import hello.SpringCoreBasic.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void crateOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
