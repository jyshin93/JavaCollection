package website;

import java.util.Scanner;

public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		Scanner scanner = new Scanner(System.in);
		String input = "", key="";
		while (true) {
			System.out.println("[JOIN]:회원가입,[LOGIN]:로그인,[LOGOUT]:로그아웃");
			input = scanner.next();
			if (input.equals("logout")) {
				System.out.println("로그아웃 성공!!");
				break;
			} else {
				switch (input) {
				case "join": // 메소드 리팩토링 단축키 ALT SHIFT M
					join(service, scanner);					
					break;
				case "login": // 로그인
					System.out.println("아이디:");
					String id2 = scanner.next();
					System.out.println("비밀번호");
					String password = scanner.next();
					String result = service.login(id2,password);
					String flag = result.substring(0,5);
					if (flag.equals("환영합니다")) {
						System.out.println(result);
						break;
					}else if (flag.equals("비번이 다")) {
						System.out.println(result);
						break;
					}else {
						System.out.println(result);
						break;
					}
				

				default:
					System.out.println("잘못 입력하였습니다.");
					break;
				}
			}
		}
	}

	private static void join(MemberService service, Scanner scanner) {
		System.out.println("userid를 입력하세요");
		String id = scanner.next();
		System.out.println("비밀번호:");
		String pass = scanner.next();
		System.out.println("이름:");
		String name = scanner.next();
		System.out.println("나이:");
		int age = scanner.nextInt();
		System.out.println("주소입력:");
		String address = scanner.next();
		service.join(id, pass, name, age, address);
		System.out.println("회원가입 성공");
	}
}
