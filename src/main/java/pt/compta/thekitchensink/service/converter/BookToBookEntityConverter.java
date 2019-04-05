package pt.compta.thekitchensink.service.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Converter;
import pt.compta.thekitchensink.repository.entity.BookEntity;
import pt.compta.thekitchensink.service.domain.Book;

@Component
public class BookToBookEntityConverter implements Converter<Book, BookEntity> {

	public Book convert(BookEntity source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new Book(bookISBN, bookName, bookSummary);
	}
}
