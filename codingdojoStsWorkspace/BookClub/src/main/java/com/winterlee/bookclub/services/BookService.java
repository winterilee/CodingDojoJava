package com.winterlee.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winterlee.bookclub.models.Book;
import com.winterlee.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bRepo;
	
	public List<Book> getAll() {
		return this.bRepo.findAll();
	}
	
	public Book getById(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
	public Book addBook(Book newBook) {
		return this.bRepo.save(newBook);
	}
	
	public Book updateBook(Book editedBook) {
		return this.bRepo.save(editedBook);
	}
	
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}
	
}
