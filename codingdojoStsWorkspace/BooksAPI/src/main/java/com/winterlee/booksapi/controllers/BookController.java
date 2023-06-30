package com.winterlee.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.booksapi.models.Book;
import com.winterlee.booksapi.services.BookService;

@Controller
@RequestMapping("/")
public class BookController {
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public String index(Model viewModel) {
		List<Book> books = bookService.allBooks();
		viewModel.addAttribute("allBooks", books);
		
		return "index.jsp";
	}
	
	
	@GetMapping("/books/{bookId}")
	public String show(@PathVariable("bookId") Long bookId, Model viewModel) {
		viewModel.addAttribute("selectedBook", bookService.findBook(bookId));
		
		return "show.jsp";
	}
	
}
