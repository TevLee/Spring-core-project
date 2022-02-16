package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class memberServiceTest {

    MemberService memberService;
    //MemberService memberService = new MemberServiceImpl();
    /**
     * 바로 appconfig에서 꺼내기 애매해서....?
     * BeforeEach 구현...
     */
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

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
