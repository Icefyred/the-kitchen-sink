package pt.compta.thekitchensink.controller.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Converter;
import pt.compta.thekitchensink.controller.model.BookModel;
import pt.compta.thekitchensink.service.domain.Book;

@Component
public class BookModelConverter implements Converter<BookModel, Book> {

	public Book convertFrom(BookModel source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new Book(bookISBN, bookName, bookSummary);
	}

	public BookModel convertTo(Book source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new BookModel(bookISBN, bookName, bookSummary);
	}
}
