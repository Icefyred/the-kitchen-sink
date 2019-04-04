package pt.compta.thekitchensink.service;

import pt.compta.thekitchensink.Book;
import pt.compta.thekitchensink.repository.BookRepository;

public class BookService {
	private BookRepository bookRepository = new BookRepository();

	public Book getBook(String bookName) {
		Book book = null;
		if ((book = bookRepository.getBookByName(bookName)) != null)
			return book;
		else
			throw new IllegalArgumentException();
	}

	public Book createBookRepository(Book book) {
		if (doesBookExist(book)) {
			throw new IllegalArgumentException();
		} else {
			bookRepository.insertBookInTheList(book);
		}
		return book;
	}

	public boolean doesBookExist(Book book) {
		boolean isTheBookAlreadyInTheList = bookRepository.getBookByName(book.getBookTitle()) != null
				|| bookRepository.getBookByName(book.getBookTitle()) != null;
		return isTheBookAlreadyInTheList;
	}
}
