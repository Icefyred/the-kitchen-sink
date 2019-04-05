package pt.compta.thekitchensink.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pt.compta.thekitchensink.repository.entity.BookEntity;

@Repository
public class BookRepository {
	private List<BookEntity> booksInMemory = new ArrayList<>();

	public void insertBookInTheList(BookEntity book) {
		booksInMemory.add(book);
	}

	public BookEntity getBookByName(String bookName) {

		for (BookEntity book : booksInMemory) {
			if (bookName.equals(book.getBookTitle())) {
				return book;
			}
		}
		return null;
	}
}
