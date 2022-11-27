package com.usa.payment.controller;

import com.usa.payment.Dto.CategoryRequestDto;
import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.model.Category;
import com.usa.payment.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/saveCategory")
    public ResponseDto saveCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
      return categoryService.saveCategory(categoryRequestDto);

       // return new ResponseDto(true,"category saving successfully");
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseDto updateCategoryById(@RequestBody CategoryRequestDto categoryRequestDto, @PathVariable Long id) {
       return categoryService.updateCategory(categoryRequestDto, id);
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseDto deleteCategoryById(@PathVariable("id") Long id) {
       return categoryService.deleteCategoryById((id));
    }

    @GetMapping("/listCategory")
    public List<Category> ListAll() {
        return categoryService.ListAllCategory();
    }

    @GetMapping("/getCategory/{id}")
    public Category getCategory(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

}
