package pt.compta.thekitchensink.service.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Converter;
import pt.compta.thekitchensink.repository.entity.BookEntity;
import pt.compta.thekitchensink.service.domain.Book;

@Component
public class BookConverter implements Converter<BookEntity, Book> {

	public Book convertFrom(BookEntity source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new Book(bookISBN, bookName, bookSummary);
	}

	public BookEntity convertTo(Book source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new BookEntity(bookISBN, bookName, bookSummary);
	}
}
