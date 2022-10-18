package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.repo.BookDao;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookDao dao;
	
	
	@GetMapping(value = "/getall")
	public List<Book> getAll(){
		List<Book> books= bookService.getAllBooks();
		return books;
	}
	
	@PostMapping("/save")
	public Book bookSave(@RequestBody Book book) {
		System.out.println(book.toString());
		return bookService.saveBookService(book);
	}
	
	@DeleteMapping("/del/{id}")
	public String delBook(@PathVariable("id") int id) {
		
		Book book= bookService.deleleBook(id);
		
		if(book!=null) {
			return "Book Deleted";
		}
		
		return "Failed";
	}
	
	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable int id,@RequestBody Book book) {
		
		book.setId(id);
		book= dao.save(book);
		return book;
		
		
	}
	
	
}
