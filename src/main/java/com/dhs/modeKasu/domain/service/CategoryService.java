package com.dhs.modeKasu.domain.service;

import com.dhs.modeKasu.application.dto.request.LendItemRequest;
import com.dhs.modeKasu.domain.model.category.Category;
import com.dhs.modeKasu.domain.model.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.dhs.modeKasu.infrastructure.exception.ErrorCode.INVALID_CATEGORY;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category findCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> INVALID_CATEGORY.build(categoryId)
        );
    }

    public Category saveCategory(String name) {
        return categoryRepository.save(Category.createCategory(name));
    }
}
