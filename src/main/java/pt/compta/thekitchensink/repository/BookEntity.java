package pt.compta.thekitchensink.repository;

public class BookEntity {

	private String bookISBN;
	private String bookTitle;
	private String bookDescription;

	public BookEntity(String bookISBN, String bookTitle, String bookDescription) {
		this.bookISBN = bookISBN;
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
	}

	public String getBookISBN() {
		return this.bookISBN;
	}

	public String getBookTitle() {
		return this.bookTitle;
	}

	public String getBookDescription() {
		return this.bookDescription;
	}
}