package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        /**
         * MemberService memberService = new MemberServiceImpl();
         * 위 코드와 달리 AppConfig에서 생성된 객체를 받아서, >> 객체 생성할 때 param은 AppConfig에서 결정한다
         * 실행...에만 집중한다.
         */
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find member = "+findMember.getName());

        if(member.getName().equals(findMember.getName())) System.out.println("new member == find member 의 이름이 "+member.getName()+"으로 같습니다.");

    }
}
