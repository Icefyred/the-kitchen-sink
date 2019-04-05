package pt.compta.thekitchensink.controller.converter;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Book;
import pt.compta.thekitchensink.controller.BookModel;

@Component
public class BookModelConverter {

	public Book convertFromBookModelToBook(BookModel source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new Book(bookISBN, bookName, bookSummary);
	}

	public BookModel convertFromBookToBookModel(Book source) {
		String bookISBN = source.getBookISBN();
		String bookName = source.getBookTitle();
		String bookSummary = source.getBookDescription();
		return new BookModel(bookISBN, bookName, bookSummary);
	}
}
