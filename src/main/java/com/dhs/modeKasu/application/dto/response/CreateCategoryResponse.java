package com.dhs.modeKasu.application.dto.response;

import com.dhs.modeKasu.domain.model.category.Category;

public record CreateCategoryResponse (
        String name,
        String message
)  {

    public static CreateCategoryResponse of (Category category) {
        return new CreateCategoryResponse(category.getName(), "카테고리 생성되었습니다.");
    }
}
