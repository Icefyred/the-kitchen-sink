package pt.compta.thekitchensink.service;

import pt.compta.thekitchensink.Book;
import pt.compta.thekitchensink.repository.BookEntity;
import pt.compta.thekitchensink.repository.BookRepository;

public class BookService {
	private BookRepository bookRepository = new BookRepository();
	private BookConverter bookConverter = new BookConverter();

	public Book getBook(String bookName) {
		BookEntity book = null;
		if ((book = bookRepository.getBookByName(bookName)) != null)
			return bookConverter.convert(book);
		else
			throw new IllegalArgumentException();
	}

	public Book createBookRepository(Book book) {
		BookEntity entity = bookConverter.convertFromBookToBookEntity(book);
		if (doesBookExist(book)) {
			throw new IllegalArgumentException();
		} else {
			bookRepository.insertBookInTheList(entity);
		}
		return book;
	}

	public boolean doesBookExist(Book book) {
		return bookRepository.getBookByName(book.getBookTitle()) != null;
	}
}
