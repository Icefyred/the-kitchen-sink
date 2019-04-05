package pt.compta.thekitchensink.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.compta.thekitchensink.repository.BookRepository;
import pt.compta.thekitchensink.repository.entity.BookEntity;
import pt.compta.thekitchensink.service.converter.BookEntityToBookConverter;
import pt.compta.thekitchensink.service.converter.BookToBookEntityConverter;
import pt.compta.thekitchensink.service.domain.Book;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookToBookEntityConverter bookToBookEntityConverter;

	@Autowired
	private BookEntityToBookConverter bookEntityToBookConverter;

	public Book getBook(String bookName) {
		BookEntity book = null;
		if ((book = bookRepository.getBookByName(bookName)) != null)
			return bookToBookEntityConverter.convert(book);
		else
			throw new IllegalArgumentException();
	}

	public Book createBookRepository(Book book) {
		BookEntity entity = bookEntityToBookConverter.convert(book);
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
