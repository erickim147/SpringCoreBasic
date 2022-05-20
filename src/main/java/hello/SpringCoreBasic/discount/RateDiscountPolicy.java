package hello.SpringCoreBasic.discount;

import hello.SpringCoreBasic.member.Grade;
import hello.SpringCoreBasic.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        // Ctrl + Shift + T = CreateTestCode
        if(member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
