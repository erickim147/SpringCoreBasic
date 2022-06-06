package hello.SpringCoreBasic.beanfind;

import hello.SpringCoreBasic.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    // Spring Bean에 등록된 모든 Bean을 꺼내보자.
    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        // 모든 빈의 이름을 가져온다. (String[] 타입)
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        // for문 자동완성 iter + tap 누르면 자동으로 for문을 완성해줌
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션션 빈 력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //BeanDefinition = bean의 meta data 정보
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            // BeanDefinition.ROLE_APPLICATION = BeanDefinition의 정보 중 내가 직접 등록한 Bean 또는 외부 라이브러리의 빈만 출력
            // Role ROLE_APPLICATION: 적접 등록한 애플리케이션 빈
            // Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }
    }
}
