package website;

import java.util.HashMap;
import java.util.Map;

public class MemberServiceImpl implements MemberService {
	/*
	 * Map<String, Member> map = new HashMap<String,Member>(); 이것이 정석이지만
	 * <String,Object>가 정석 하지만 이 예제에서는 <String,String>으로 한다 이유는 쉽게 가려고...
	 */
	Map<String, String> map = new HashMap<String, String>();
	Member member = new Member();
	String id, pass, name, address;
	int age;

	@Override
	public void join(String id, String pass, String name, int age, String address) {
		member.setId(id);
		member.setPass(pass);
		member.setName(name);
		member.setAge(age);
		member.setAddress(address);
		map.put("userid", member.getId());
		map.put("password", member.getPass());
		map.put("name", member.getName());
		map.put("age", String.valueOf(member.getAge())); // 인트를 String타입으로 바꾸는 것은 String.Valueof
															
		map.put("address", member.getAddress());
	}

	@Override
	public String login(String id2, String password) {
		String msg = "";
		if (map.get("userid").equals(id2)&&
				map.get("password").equals(password)) {
			msg = "환영합니다." + member.getAddress()+"에 사시는"
					+ member.getAge()+"세 되시는"
					+member.getName()+"님.";
		}else if (map.get("userid").equals(id2)&&
				!map.get("password").equals(password)) {
			msg = "비번이 다릅니다. 다시 입력하세요";
		}else {
			msg = "입력하신 ID는 존재하지 않거나, 일치하지 않습니다. 다시 입력하세요.";
		}
		return msg;

	}
}
