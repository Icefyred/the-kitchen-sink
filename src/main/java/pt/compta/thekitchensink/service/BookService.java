package pt.compta.thekitchensink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.compta.thekitchensink.Book;
import pt.compta.thekitchensink.repository.BookEntity;
import pt.compta.thekitchensink.repository.BookRepository;
import pt.compta.thekitchensink.service.converter.BookConverter;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookConverter bookConverter;

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
