package pt.compta.thekitchensink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.compta.thekitchensink.Book;
import pt.compta.thekitchensink.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public Book book(@RequestParam("title") String titleParamValue) {
		return bookService.getBook(titleParamValue);
	}

	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {
		bookService.createBookRepository(book);
		return book;
	}
}
