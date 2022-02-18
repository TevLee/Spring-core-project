package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
        /**
         * MemberService memberService = new MemberServiceImpl();
         * 위 코드와 달리 AppConfig에서 생성된 객체를 받아서, >> 객체 생성할 때 param은 AppConfig에서 결정한다
         * 실행...에만 집중한다.
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig의 bean들을 가져와서 스프링컨테이너에서 관리 시작
        /**
         * 아래 코드에서,
         * ApplicationContext(스프링 컨테이너)
         * applicationContext의 (매칭되는)bean을 가져옴... (name은 bean의 메서드명)
         * 왜냐하면, @bean이 스프링컨테이너에 등록될 때, key=메서드명 - value는 반환 변수형(?)으로 해서 등록되므로...
         * 차이점은, 직접 AppConfig.java에서 가져오는가 -> 스프링 컨테이너에서(관리중인 bean을) 가져오는가
         */
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find member = "+findMember.getName());

        if(member.getName().equals(findMember.getName())) System.out.println("new member == find member 의 이름이 "+member.getName()+"으로 같습니다.");

    }
}
