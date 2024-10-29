package Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberPanel {

    private Map<Integer, Member> memberMap;

    public MemberPanel() {
        this.memberMap = new HashMap<Integer, Member>();
    }

    public Member addAsMember(String name, String number, String address) {
        Member member = new Member(memberMap.keySet().size() + 1, name, number, address);
        memberMap.put(member.getId(), member);
        return member;
    }

    public Boolean removeMember(Member member) {
        if (memberMap.containsKey(member.getId())) {
            memberMap.remove(member.getId());
            return true;
        }
        System.out.printf("Member with id %d is not present%n", member.getId());
        return false;
    }

    public List<Member> getAllMembers() {
        return this.memberMap.values().stream().toList();
    }

    public Boolean updateMember(Member member) {
        if (memberMap.containsKey(member.getId())) {
            Member existingMember = memberMap.get(member.getId());
            existingMember.setName(member.getName());
            existingMember.setAddress(member.getAddress());
            existingMember.setNumber(member.getNumber());
            return true;
        }
        System.out.printf("Couldn't find member with ID %d %n", member.getId());
        return false;
    }
}
