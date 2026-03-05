package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvalidGradeException;

public class StudentTest {

	public static void main(String[] args) {
		
		// 에러가 발생할 가능성이 있는 코드는 반드시 try 블록 안에 넣어야 합니다.
		try {
			// 1. 정상적인 학생 객체 생성
			Student student = new Student("S1234", "김민수", "컴퓨터공학", 3);
			
			// 2. 현재 정보 출력
			System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
			
			// 3. 5학년으로 잘못된 변경 시도 (여기서 빵! 하고 예외가 터져서 아래로 튕겨 나갑니다)
			System.out.println("5학년으로 변경 ");
			student.setGrade(5);
			
			// (참고) 위에서 에러가 터졌기 때문에 이 아래 코드는 실행되지 않습니다.
			// System.out.println("이 글씨는 출력되지 않습니다.");
			
		} catch (InvalidGradeException e) {
			// 4. 던져진 에러 폭탄을 방패(catch)로 막고, 에러 안에 담긴 메시지를 예쁘게 출력
			System.out.println(e.getMessage());
		}

	}
}