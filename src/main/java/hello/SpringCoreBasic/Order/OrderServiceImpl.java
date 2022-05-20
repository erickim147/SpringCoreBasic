package hello.SpringCoreBasic.Order;

import hello.SpringCoreBasic.discount.DiscountPolicy;
import hello.SpringCoreBasic.discount.FixDiscountPolicy;
import hello.SpringCoreBasic.member.Member;
import hello.SpringCoreBasic.member.MemberRepository;
import hello.SpringCoreBasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }



}
