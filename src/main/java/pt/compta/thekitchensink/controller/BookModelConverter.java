package pt.compta.thekitchensink.controller;

import org.springframework.stereotype.Component;

import pt.compta.thekitchensink.Book;

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
