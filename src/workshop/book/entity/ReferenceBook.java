package workshop.book.entity;

// 참조서
public class ReferenceBook extends Publication {
	// 상속 받은 속성이 아니라 ReferenceBook이 가지는 독자적인 속성
	private String field;
	
	public ReferenceBook() {
		
	}

	public ReferenceBook(String title, String publishingDate, int page, int price, String field ) {
		super(title, publishingDate, page, price);
		this.field = field;
	}

	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
}
