package hello.SpringCoreBasic;

import hello.SpringCoreBasic.Order.OrderService;
import hello.SpringCoreBasic.Order.OrderServiceImpl;
import hello.SpringCoreBasic.discount.DiscountPolicy;
import hello.SpringCoreBasic.discount.FixDiscountPolicy;
import hello.SpringCoreBasic.discount.RateDiscountPolicy;
import hello.SpringCoreBasic.member.MemberRepository;
import hello.SpringCoreBasic.member.MemberService;
import hello.SpringCoreBasic.member.MemberServiceImpl;
import hello.SpringCoreBasic.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 기존 AppConfig 를 리팩토링 하자
    // memberService와 orderService에는 new MemoryMemberRepository가 중복된다.
    // 중복된 부분을 제거하고 MemoryMemberRepository를 DB로 변경 하더라도 한 부분만 변경되도록 리팩토링 한다.
    // 또한, 역할에 따른 구현이 잘 보이지 않기 때문에 한눈에 잘 들어올 수 있도록 리팩토링 하는 것이 중요한다.

// 기존 로직
//    public MemberService memberService(){
//
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    public OrderService orderService() {
//        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
//    }

    // 변경 로직
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();

    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // FixDiscountPolicy -> RateDiscountPolicy로 변경해보자.
    // 할인 정책을 변경 하더라도 AppConfig의 등장으로 사용 영역의 코드 변경 없이 적용이 가능하다.
    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy(); // 정액 할인 정책
        return new RateDiscountPolicy(); // 정률 할인 정책
    }

}

// AppConfig Class를 스프링 타입으로 바꿔보자
/*
*   1. Class 위에 @Configuration 애노테이션을 붙여준다.
*   2. Method에는 @Bean 애노테이션을 붙여준다.
*
*
* */

/*
*   @Configuration과 싱글톤
*
*   @Bean memberService -> new MemoryMemberRepository()
*   @Bean orderService -> new MemoryMemberRepository()
*   이렇게 new MemoryMemberRepository를 생성하면 싱글톤이 깨질까 안깨질까?
*   결과적으로 각각 다른 2개의 객체를 생성하면 싱글톤이 깨지는 것 처럼 보인다.
*   여기서 스프링 컨테이너는 어떻게 이 문제를 해결할까?
*
*   호출 순서를 보면
*   // call AppConfig.memberService
*   // call AppConfig.memberRepository
*   // call AppConfig.memberRepository
*   // call AppConfig.orderService
*   // call AppConfig.memberRepository
*
*   순으로 호출이 되어야 한다. 하지만, 실제 실행 결과
*   // call AppConfig.memberService
*   // call AppConfig.memberRepository
*   // call AppConfig.orderService
*   이렇게 memberRepository는 한번만 호출된다.
* */