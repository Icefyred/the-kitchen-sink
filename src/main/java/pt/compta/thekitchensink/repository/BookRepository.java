package pt.compta.thekitchensink.repository;

import java.util.ArrayList;
import java.util.List;

import pt.compta.thekitchensink.Book;

public class BookRepository {
	private List<Book> booksInMemory = new ArrayList<>();

	public void insertBookInTheList(Book book) {
		booksInMemory.add(book);
		System.out.println("Inserted object: " + book);
	}

	public Book getBookByName(String bookName) {

		for (Book book : booksInMemory) {
			if (bookName.equals(book.getBookTitle())) {
				return book;
			}
		}
		return null;
	}
}
