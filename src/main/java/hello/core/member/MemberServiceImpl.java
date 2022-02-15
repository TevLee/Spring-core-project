package hello.core.member;

public class MemberServiceImpl implements MemberService{

    //final은 왜 해주는걸까?
    // DIP를 따르지 않는다... 무슨말? //추상화에도 의존하고, 구체화에도 의존한단다..
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
