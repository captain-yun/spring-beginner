package hello.member.respository;

import hello.member.domain.Member;

import java.awt.*;
import java.util.*;
import java.util.List;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
//        Set<Long> ketSet = store.keySet();
//        // member들의 id가 전부 set에 담김
//        Iterator<Long> id = ketSet.iterator();
//        while(id.hasNext()) {
//            Member member = store.get(id.next());
//            if( name.equals(member.getName()) ) {
//                return Optional.ofNullable(member);
//            };
//        }
//        return Optional.ofNullable(null);

        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
