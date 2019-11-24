package com.bazzoli.company.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bazzoli.company.company.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	}


