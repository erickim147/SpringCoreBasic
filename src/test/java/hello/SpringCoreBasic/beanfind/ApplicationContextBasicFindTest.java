package hello.SpringCoreBasic.beanfind;

import hello.SpringCoreBasic.AppConfig;
import hello.SpringCoreBasic.member.MemberService;
import hello.SpringCoreBasic.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //System.out.println("memberService = " + memberService);
        //System.out.println("memberService.getClass() = " + memberService.getClass());
        // Assertions static 으로 만드는 단축키 = Alt+Enter -> Add on-demand static ...
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 구체타입으로 조회하면 유연성이 떨어지기 때문에 가능한 인터페이스를 조회하는것이 좋다.
    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // Test는 항상 실패 테스트 코드도 함께 만들어야 한다.
    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() {
        //MemberService xxxx = ac.getBean("xxxx", MemberService.class);
        // 실제 Test 코드를 돌려보면
        // org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'xxxx' available Exception이 터진다.

        // junit Assertions를 static으로 등록 후
        // assertThrows로 오른쪽 오직을 실행하면 왼쪽의 Exception이 터져야 Test 성공
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean("xxxx", MemberService.class));
    }
}
