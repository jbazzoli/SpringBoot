package com.bazzoli.company.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bazzoli.company.company.model.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{
}
