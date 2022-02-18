package hello.core.member;

public class MemberServiceImpl implements MemberService{


    // DIP를 따르지 않는다 > AppConfig 사용하면서 DIP 따름... 생성자 주입
    private final MemberRepository memberRepository; //new MemoryMemberRepository();

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }
    @Override
    public Member findMember(Long memberId) {return memberRepository.findById(memberId);
    }
}
