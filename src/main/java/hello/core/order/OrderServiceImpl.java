package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    /**
     * repository에서 멤버 찾고,
     * 고정할인 정책... 필요.
     */
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 이 클래스에서 discount에 대한 부분은 생성된 discountPolicy 객체에게 넘김
        int discountPrice = discountPolicy.discount(member, itemPrice);

        ////Order 객체 생성시켜서 리턴
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
