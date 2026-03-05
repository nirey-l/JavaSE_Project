package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	// 1. 캡슐화: 모든 필드를 외부에서 직접 접근할 수 없도록 private으로 숨김
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	// 기본 생성자
	public Student() {}

	// 모든 필드를 초기화하는 생성자 (학년 세팅 시 에러가 날 수 있으므로 throws 선언)
	public Student(String studentId, String name, String major, int grade) throws InvalidGradeException {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
		setGrade(grade); // 값을 직접 넣지 않고, 검증 로직이 있는 setter를 사용!
	}

	// 2. Getter & Setter: 안전하게 값을 꺼내고 넣는 통로
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGrade() {
		return grade;
	}

	// 3. 핵심 로직: 1~4학년이 아니면 에러 폭탄(Exception)을 던짐
	public void setGrade(int grade) throws InvalidGradeException {
		if (grade < 1 || grade > 4) {
			// 강제로 내가 만든 예외를 발생시킴
			throw new InvalidGradeException("학년은 1~4 사이여야 합니다.");
		}
		this.grade = grade; // 정상적인 값이면 저장
	}
}