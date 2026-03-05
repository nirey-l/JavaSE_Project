package mylab.student.exception;

// 자바의 기본 Exception 클래스를 상속받아 나만의 에러 창조
public class InvalidGradeException extends Exception {
	
	// 에러 메시지를 받아서 부모(Exception)에게 전달하는 생성자
	public InvalidGradeException(String message) {
		super(message);
	}
}