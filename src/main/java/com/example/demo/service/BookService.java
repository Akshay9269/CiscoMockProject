package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Book;
import com.example.demo.repo.BookDao;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	
	
	public List<Book> getAllBooks(){
		return bookDao.findAll();
	}
	
	public Book saveBookService(Book book) {
		return bookDao.save(book);
	}
	
	public Book deleleBook(int id) {
		 Optional<Book> book= bookDao.findById(id);
		 return book.orElse(null);
		 
	}
	
}
