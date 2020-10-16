package com.example.codeengine.expense.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import com.example.codeengine.expense.model.Category;
import com.example.codeengine.expense.repository.CategoryRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CategoryController {
    // the table whose data we need to retreive, update, delete or create
    private CategoryRepository categoryRepo;

    public CategoryController(CategoryRepository categoryRepo) {
        super();
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("/categories")
    Collection<Category> categories() {
        return categoryRepo.findAll();
    }

    @GetMapping("/category/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id) {
        // optional because the id maybe invalid
        Optional<Category> category = categoryRepo.findById(id);

        // map the category object we got from database to the responseentity body if we
        // have something in the category.
        // else we will create a new ResponseEntity and send the NOT_FOUND HttpStatus
        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@Valid @RequestBody Category category) throws URISyntaxException {
        Category result = categoryRepo.save(category);

        return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
    }

    @PutMapping("/category/{id}")
    ResponseEntity<Category> updateCategory(@Valid @RequestBody Category category) throws URISyntaxException {
        Category result = categoryRepo.save(category);

        return ResponseEntity.ok().body(result);
    }
}
