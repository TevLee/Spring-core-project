package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 환경구성은 여기서 다함
 * 필요한 구현 객체 생성 + 생성자를 통해서 주입(연결)
 */
/**
 * @Bean의 호출을 통해 반환된 객체를 스프링 컨테이너에 등록한다...
 * Bean의 이름은 메서드명으로 한다(수정가능하나, 관례상...)
 *
 */
@Configuration
public class AppConfig { //Refactoring(Ctrl+Alt+M) 후... << MemoryMemberRepository 생성 코드 추가

    @Bean
    public MemberService memberService(){ return new MemberServiceImpl(memberRepository()); }
    /**
     * Refactoring의 장점
     * 1) 객체 내용과 역할을 가시적으로 볼 수 있음
     * 2) 저장소를 Memory > DB 등으로 수정할 때
     * 아래 코드만 수정하면 끝!
     */
    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    /**
     * 할인 정책 수정 시,
     * 아래 코드만 수정하면 됨
     * DIP, OCP 충족
     */
    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
