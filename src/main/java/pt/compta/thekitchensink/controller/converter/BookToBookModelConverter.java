package pt.compta.thekitchensink.controller.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Converter;
import pt.compta.thekitchensink.controller.model.BookModel;
import pt.compta.thekitchensink.service.domain.Book;

@Component
public class BookToBookModelConverter implements Converter<Book, BookModel> {
	public Book convert(BookModel source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new Book(bookISBN, bookName, bookSummary);
	}
}
