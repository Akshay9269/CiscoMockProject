package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Book;

public interface BookDao extends JpaRepository<Book, Integer> {

}
