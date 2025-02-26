package com.dhs.modeKasu.application.facade;

import com.dhs.modeKasu.application.dto.request.CreateCategoryRequest;
import com.dhs.modeKasu.application.dto.response.CreateCategoryResponse;
import com.dhs.modeKasu.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryFacade {
    private final CategoryService categoryService;

    public CreateCategoryResponse createCategory(CreateCategoryRequest request) {
        return CreateCategoryResponse.of(
                categoryService.saveCategory(request.name())
        );
    }

}
