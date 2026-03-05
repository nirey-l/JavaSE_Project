package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books; // Book 객체들을 담을 가변 길이 배열(리스트)

    // 생성자
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>(); // 빈 도서 목록 생성
    }

    public String getName() {
        return name;
    }

    // 도서 추가
    public void addBook(Book book) {
        books.add(book);
        System.out.println("도서가 추가되었습니다: " + book.getTitle());
    }

    // 제목으로 검색
    public Book findByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null; // 못 찾으면 null 반환
    }

    // 저자로 검색 (한 저자가 여러 권을 썼을 수 있으므로 List로 반환)
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // ISBN으로 검색
    public Book findByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    // 도서 대출 (위임: Library가 직접 상태를 바꾸지 않고 Book에게 지시함)
    public boolean checkOutBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null) {
            return book.checkOut(); // 책에게 대출 처리하라고 시킴
        }
        return false;
    }

    // 도서 반납
    public boolean returnBook(String isbn) {
        Book book = findByISBN(isbn);
        if (book != null) {
            book.returnBook();
            return true;
        }
        return false;
    }

    // 대출 가능한 도서 목록 반환
    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    // 모든 도서 목록 반환
    public List<Book> getAllBooks() {
        return books;
    }

    // 통계: 전체 도서 수
    public int getTotalBooks() {
        return books.size();
    }

    // 통계: 대출 가능 도서 수
    public int getAvailableBooksCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    // 통계: 대출 중인 도서 수
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
}