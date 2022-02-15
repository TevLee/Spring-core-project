package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class memberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given : 주어졌을때
        Member member = new Member(1L,"memberB",Grade.VIP);

        //when : 이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then :  이렇게 된다
        Assertions.assertThat(member).isEqualTo(findMember); //member가 findMember와 동일한지
        System.out.println(member);
        System.out.println(findMember);
    }
}
