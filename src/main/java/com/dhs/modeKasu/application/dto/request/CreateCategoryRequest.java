package com.dhs.modeKasu.application.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateCategoryRequest(
        @NotBlank(message = "카테고리명은 필수 항목입니다.")
        String name
) {
}
