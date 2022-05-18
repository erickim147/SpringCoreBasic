package hello.SpringCoreBasic.discount;

import hello.SpringCoreBasic.member.Grade;
import hello.SpringCoreBasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixPolicy = 1000;

    @Override
    public int discount(Member member, int price) {
        // enum 타입은 연산자를  == 으로 비교하는 것이 맞다.
        if(member.getGrade() == Grade.VIP) {
            return discountFixPolicy;
        } else {
            return 0;
        }
    }
}
