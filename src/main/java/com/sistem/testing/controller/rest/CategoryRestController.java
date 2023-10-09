package com.sistem.testing.controller.rest;

import com.sistem.testing.model.quiz.Category;
import com.sistem.testing.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/category")
public class CategoryRestController {
    private CategoryService categoryService;
    public CategoryRestController(CategoryService categoryService ){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> saveCategory( @RequestBody Category category ){
        return ResponseEntity.ok( this.categoryService.saveCategory( category ) );
    }

    @GetMapping
    public ResponseEntity< Set<Category> > allCategory(){
        return ResponseEntity.ok( this.categoryService.allCategories() );
    }

    @PutMapping
    public ResponseEntity<Category> updateCategory( @RequestBody Category category ){
        return ResponseEntity.ok( this.categoryService.updateCategory( category ) );
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable long id){
        this.categoryService.deleteCategory( id ) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategory(@PathVariable long id){
        return ResponseEntity.ok( this.categoryService.findById( id ) );
    }
}
