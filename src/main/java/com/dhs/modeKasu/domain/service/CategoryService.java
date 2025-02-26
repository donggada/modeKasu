package com.dhs.modeKasu.domain.service;

import com.dhs.modeKasu.domain.model.category.Category;
import com.dhs.modeKasu.domain.model.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category findCategory() {
        return Category.createCategory("");
    }
}
