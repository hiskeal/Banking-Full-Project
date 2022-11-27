package com.usa.payment.service;

import com.usa.payment.Dto.CategoryRequestDto;
import com.usa.payment.Dto.CategoryResponseDto;
import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.model.Category;
import com.usa.payment.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public ResponseDto saveCategory(CategoryRequestDto categoryRequestDto) {

        Category category = new Category();
        category.setDescription(categoryRequestDto.getDescription());
        categoryRepository.save(category);
        return new ResponseDto(true, "save category successfully");
    }

    public ResponseDto updateCategory(CategoryRequestDto categoryRequestDto, Long id) {

        Category category = categoryRepository.findById(id).get();

        category.setDescription(categoryRequestDto.getDescription());
        categoryRepository.save(category);
        return new ResponseDto(true, "Category updated");
    }

    public ResponseDto deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
        return new ResponseDto(true, "Category deleted");
    }

    public List<Category> ListAllCategory() {
        List<CategoryResponseDto>categoryResponseDto = new ArrayList<>();
        return (List<Category>)categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {

        return categoryRepository.findById(id).get();
    }

}
