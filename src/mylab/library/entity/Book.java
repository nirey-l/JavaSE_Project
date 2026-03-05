package mylab.library.entity;

public class Book {
    // 1. 캡슐화: 모든 필드를 private으로 은닉
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private boolean isAvailable;

    // 기본 생성자
    public Book() {
        this.isAvailable = true; // 초기 생성 시 대출 가능 상태로 설정
    }

    // 모든 필드를 초기화하는 생성자
    public Book(String title, String author, String isbn, int publishYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.isAvailable = true; // 초기 생성 시 대출 가능 상태로 설정
    }

    // 2. 외부 통로: Getter와 Setter
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public int getPublishYear() { return publishYear; }
    public void setPublishYear(int publishYear) { this.publishYear = publishYear; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isAvailable) { this.isAvailable = isAvailable; }

    // 3. 핵심 기능: 대출 처리 (스스로 상태 변경)
    public boolean checkOut() {
        if (this.isAvailable) {
            this.isAvailable = false;
            return true; // 대출 성공
        }
        return false; // 이미 대출 중이면 실패
    }

    // 핵심 기능: 반납 처리
    public void returnBook() {
        this.isAvailable = true;
    }

    // 4. 정보 출력 포맷 지정 (Sample Run의 양식에 맞춤)
    @Override
    public String toString() {
        String status = isAvailable ? "가능" : "대출 중";
        return "책 제목: " + title + "\t저자: " + author + "\tISBN: " + isbn + "\t출판년도: " + publishYear + "\t대출 가능 여부: " + status;
    }
}