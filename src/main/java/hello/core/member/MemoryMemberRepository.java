package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    //member의 번호와 member 객체를 저장하기위한 해시맵
    //member의 번호는 객체에 따라서가 아니라, 몇명인지 기록해야되니까. static으로 선언...
    private static Map<Long, Member> store = new HashMap<>(); //동시성 이슈 >> contront hashmap?

    @Override
    public void save(Member member) {
        store.put(member.getId(),member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //HashMap인 store(멤버 저장소)에서 id를 key로 하는 value를 가져온다.
    }
}
