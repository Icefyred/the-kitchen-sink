package pt.compta.thekitchensink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.compta.thekitchensink.controller.converter.BookModelConverter;
import pt.compta.thekitchensink.controller.model.BookModel;
import pt.compta.thekitchensink.service.BookService;
import pt.compta.thekitchensink.service.domain.Book;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@Autowired
	private BookModelConverter bookModelConverter;

	@GetMapping("/books")
	public BookModel book(@RequestParam("title") String titleParamValue) {
		return bookModelConverter.convertFromBookToBookModel(bookService.getBook(titleParamValue));
	}

	@PostMapping("/books")
	public BookModel createBook(@RequestBody BookModel bookModel) {
		Book book = bookModelConverter.convertFromBookModelToBook(bookModel);
		bookService.createBookRepository(book);
		return bookModel;
	}
}
