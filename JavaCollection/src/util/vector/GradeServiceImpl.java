package util.vector;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
/*
 프로그램을 코딩하다 보면
 자료구조를 다루는 데 있어서
 CRUD 액션의 반복을 경험하게 됩니다.
 Create : 입력, 생산
 Read : 출력, 조회
 Update : 수정 -> 저장된 값을 수정 DB
 Delete : 삭제 -> 완전삭제 DB, null 값으로 바꾸는 삭제
 * */

public class GradeServiceImpl implements GradeService {
	// 필드에 아래 메소드들이 공유할 자료구조를 뭘 쓸까?
	// 1. ArrayList 2. Vector 3. Stack 4. HashMap
	// 순서 0, 중복 0
	private Vector<Grade> vec = new Vector<Grade>();
	Grade grade = new Grade(); 
	
	@Override
	public void input(Grade grade) {
		// 성적표 입력
		// 만약 자료구조로 배열을 사용했다면 vec[0] = hong;
		vec.add(grade);
	}

	@Override
	public void printList() {
		// 전체 출력
		System.out.println(vec.toString());// vec의 전체를 보여주는 것 vec.toString
		
	}

	@Override
	public String searchGradeByHakbun(String hakbun) {
		// 학번으로 검색
		String msg = "";
		Grade grade = null; //지변으로 인스턴스를 선언했으므로 초기화 해야한다.
		// List 계열의 클래스 길이는 size() 구한다.
		for (int i = 0; i < vec.size(); i++) {
			// 만약 vec 가 배열이라면
			// vec.get(i)
			String searchHakbun = vec.elementAt(i).getHakbun();
			// 객체.메소드.메소드.메소드.메소드 이런 패턴이 가능할 때는
			// 반드시 return 값이 있는 메소드들끼리 연결시에만 가능하다.!
			// 이런 방식을 메소드 체인이라고 함
			if (hakbun.equalsIgnoreCase(searchHakbun)) {
				String name = vec.elementAt(i).getName();
				int kor = vec.elementAt(i).getKor();
				int eng = vec.elementAt(i).getEng();
				int math = vec.elementAt(i).getMath();
				grade = new Grade(searchHakbun,name, kor, eng, math);
				msg = grade.toString();
				break; // 중간에 
				
			}else {
				msg = "조회하는 학번이 없습니다.";
			}
			
		}
		return msg;
	}

	@Override
	public void ascGradeTotal() {
		// 성적정렬
		
	}

	@Override
	public Vector<Grade> searchGradeByName(String name) {
		Vector<Grade> temp = new Vector<Grade>();
		Grade grade = null;
		for (int i = 0; i < vec.size(); i++) {
			String searchName = vec.elementAt(i).getName();
			// 고정값(파라미터).euqlas(변수값)
			if (name.equalsIgnoreCase(searchName)) {
				grade = new Grade(vec.elementAt(i).getHakbun(), searchName,
						vec.elementAt(i).getKor(),
						vec.elementAt(i).getEng(),
						vec.elementAt(i).getMath());
				temp.add(grade);
			}else {
				//temp라는 백터를 완전히 비워서 null 로 리턴
				temp.remove(new Grade()); //비어있는 vector로 리턴한다.
			}
		}
		return temp;
	}

	@Override
	public void descByTotal() {
		// Java API 정렬담당 클래스 Comparator
		// Comparator
		// 인터페이스를 구현한 익명 내부 클래스
		// anonymous inner class
		Comparator<Grade> desc = new Comparator<Grade>() {
			
			@Override
			public int compare(Grade g1, Grade g2) {
				// 삼항연산자
				/*
				 if(조건식){
				 	--> true 면 statement 실행
				 }else{
				 	--> flase 면 statement 실행
				 }
				 (조건식) ? 참 : 거짓;
				 * */ 
				/*if (g1.getTotal()<g2.getTotal()) {
					return 1;
				}else {
					if (g1.getTotal()==g2.getTotal()) {
						return 0;
					}else {
						return -1;
					}
				}*/
				return (g1.getTotal() < g2.getTotal()) ? 1 :  
						(g1.getTotal()==g2.getTotal()) ? 0 : -1;
			}
		};
		Collections.sort(vec,desc);
		System.out.println(vec.toString());
	}

	@Override
	public void ascByName() {
		Comparator<Grade> asc = new Comparator<Grade>() {
			
			public int compare(Grade n1, Grade n2){
				// 값(value) 이 int 타입이 아니고
				// String 타입의 우선순위 결정할 때는...compareTo를 사용!!!
				
				
				return n1.getName().compareTo(n2.getName());
			}
		};
		Collections.sort(vec,asc);
		System.out.println(vec.toString());
		
	}

	/*@Override
	public String searchGradeByName(String name) {
		String msg = "";
		Grade grade = null;
		for (int i = 0; i < vec.size(); i++) {
			String searchName = vec.elementAt(i).getName();
			if (name.equalsIgnoreCase(searchName)) {
				String hakbun = vec.elementAt(i).getHakbun();
				int kor = vec.elementAt(i).getKor();
				int eng = vec.elementAt(i).getEng();
				int math = vec.elementAt(i).getMath();
				grade = new Grade(hakbun, searchName, kor, eng, math);
				msg = grade.toString();
				break;
			}else {
				msg = "조회하는 이름이 없습니다.";
			}
		}
		return msg;
	}*/

	
}
