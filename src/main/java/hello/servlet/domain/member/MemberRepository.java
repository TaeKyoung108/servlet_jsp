package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    동시성 문제가 고려되어 있지않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
*/
public class MemberRepository {

//    하나만 생성되게 하기위해 static 사용했지만 사실 아래에서 싱글톤 구현했기때문에 지금 굳이 필요하진 않음
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

//    애로만 조회 가능
    public static MemberRepository getInstance(){
        return instance;
    }

//    생성자를 private으로 해서 다른데서 생성 못하게 함
    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
//        새로운 ArrayList에 담아서 보내는 이유는 store 자체에서 보내면 store 값 수정될까봐 보호하기 위해 사용
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }


}
