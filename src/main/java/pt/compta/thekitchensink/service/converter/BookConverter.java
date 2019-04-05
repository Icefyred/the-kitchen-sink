package pt.compta.thekitchensink.service.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.repository.entity.BookEntity;
import pt.compta.thekitchensink.service.domain.Book;

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
