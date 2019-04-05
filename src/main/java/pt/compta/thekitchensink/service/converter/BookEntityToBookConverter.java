package pt.compta.thekitchensink.service.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Converter;
import pt.compta.thekitchensink.repository.entity.BookEntity;
import pt.compta.thekitchensink.service.domain.Book;

@Component
public class BookEntityToBookConverter implements Converter<BookEntity, Book> {

	public BookEntity convert(Book source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new BookEntity(bookISBN, bookName, bookSummary);
	}
}
