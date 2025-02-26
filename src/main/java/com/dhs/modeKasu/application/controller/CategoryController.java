package com.dhs.modeKasu.application.controller;

import com.dhs.modeKasu.application.dto.request.CreateCategoryRequest;
import com.dhs.modeKasu.application.dto.response.CreateCategoryResponse;
import com.dhs.modeKasu.application.facade.CategoryFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryController {
    private final CategoryFacade categoryFacade;

    @PostMapping("")
    public CreateCategoryResponse createCategory(@RequestBody @Valid CreateCategoryRequest request) {
        return categoryFacade.createCategory(request);
    }
}
