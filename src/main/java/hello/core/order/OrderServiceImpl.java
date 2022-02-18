package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    /**
     * repository에서 멤버 찾고,
     * 고정할인 정책... 필요.
     */
    private final MemberRepository memberRepository;// = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy;// = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // DIP가 지켜지지않음
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /**
     * 위 2줄을 아래와 같이 수정하면, 이 클래스는 인터페이스(DiscountPolicy)에 의존 > DIP 정책에 적합
     * -> 그럼, 구현체(객체)가 없는데... (NULLPOINTEXCEPTION)
     * -> AppConfig 등장!
     * -> 할인전략을 정액(FixDiscountPolicy)에서 정률(RateDiscountPolicy)로 수정하고 싶을 때는
     * -> AppConfig의 OrderServiceImpl 생성자의 파라미터(param)만 수정해주면 될 뿐, client인 이 클래스는 수정 불필요! == DIP?
     */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        /**
         * 여기서 구현체를 생성해주어야 하는데...
         * -> 해결 방안 : 누군가(?)가 구현체를 대신 생성해서 이 클래스에 주입(?) 시켜 주어야 한다
         */
        // 이 클래스에서 discount에 대한 부분은 생성된 discountPolicy 객체에게 넘김
        int discountPrice = discountPolicy.discount(member, itemPrice);
        ////Order 객체 생성시켜서 리턴
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
