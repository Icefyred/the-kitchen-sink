package pt.compta.thekitchensink.service.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Book;
import pt.compta.thekitchensink.repository.BookEntity;

@Component
public class BookConverter {

	public Book convert(BookEntity source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new Book(bookISBN, bookName, bookSummary);
	}

	public BookEntity convertFromBookToBookEntity(Book source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new BookEntity(bookISBN, bookName, bookSummary);
	}
}
