package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        /**
         *  MemberService memberService = new MemberServiceImpl(null);
         *  OrderService orderService = new OrderServiceImpl(null,null);
         *  AppConfig 사용해서 아래와 같이 수정
         */
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
        /**
         * 위 세줄(직접 AppConfig 객체를 생성한 것)과 달리
         * 아래 코드에서는 스프링컨테이너를 사용...
         * 궁금증) MemberApp에서와 동일한 변수명(applicationContext)을 사용하였는데 상관없는 건가...?
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = "+order);
        System.out.println("order.calculatePrice = "+order.calculatePrice());

    }
}
