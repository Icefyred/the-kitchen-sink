package pt.compta.thekitchensink.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.compta.thekitchensink.Book;
import pt.compta.thekitchensink.service.BookService;

@RestController
public class BookController {
	private BookService bookService = new BookService();

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public Book book(@RequestParam("title") String titleParamValue) {
		return bookService.getBook(titleParamValue);
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {
		System.out.println("ISBN: " + book.getBookISBN());
		System.out.println("Book Title: " + book.getBookTitle());
		System.out.println("Book Description: " + book.getBookDescription());
		bookService.createBookRepository(book);
		return book;
	}
}
