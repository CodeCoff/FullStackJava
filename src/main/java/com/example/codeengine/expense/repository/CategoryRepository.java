package com.example.codeengine.expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeengine.expense.model.Category;


// this is how we connect to the database
// here we are saying that we want to connect to ta database table with model "Category" that has 'id' of long type
// once we extend the JpaRepository, everything is handled by JPA(hibernate)
public interface CategoryRepository  extends JpaRepository<Category, Long>{

	// findByFieldName
	Category findByName(String name);
}
