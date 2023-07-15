package com.winterlee.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winterlee.bookclub.models.Book;
import com.winterlee.bookclub.services.BookService;
import com.winterlee.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bService;
	@Autowired
	private UserService uService;
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("newBook")Book newBook, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		return "newBook.jsp";
	}
	
	@PostMapping("/add")
	public String addBook(@Valid @ModelAttribute("newBook")Book newBook, BindingResult result, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if(result.hasErrors()) {
			return "newBook.jsp";
		}
		newBook.setCreator(this.uService.findById((Long)session.getAttribute("userId")));
		this.bService.addBook(newBook);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("show/{bookId}")
	public String showBook(@PathVariable("bookId")Long bookId, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		viewModel.addAttribute("bookToShow", this.bService.getById(bookId));
		
		return "showBook.jsp";
	}
	
	@GetMapping("/edit/{bookId}")
	public String editBook(@PathVariable("bookId")Long bookId, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		viewModel.addAttribute("bookToEdit", this.bService.getById(bookId));
		
		return "editBook.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String updateBook(@Valid @ModelAttribute("bookToEdit")Book editedBook, BindingResult result, 
			@PathVariable("id")Long bookId, Model viewModel, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		
		if (result.hasErrors()) {
			viewModel.addAttribute("bookToEdit", this.bService.getById(bookId));
			return "editBook.jsp";
		} else {
			editedBook.setCreator(this.uService.findById((Long)session.getAttribute("userId")));
			this.bService.updateBook(editedBook);
			
			return "redirect:/books/show/"+bookId;
		}
	}
	
	@GetMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId")Long bookId, HttpSession session) {
		this.bService.deleteBook(bookId);
		
		return "redirect:/dashboard";
	}
	
}
