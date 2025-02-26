package com.dhs.modeKasu.application.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record LendItemRequest(
        @NotBlank(message = "브랜드명은  필수 항목입니다.")
        String brand,

        @NotBlank(message = "상품명은 필수 항목입니다.")
        String name,

        @NotNull(message = "카테고리 선택은 필수 항목입니다.")
        Long categoryId,

        @NotBlank(message = "시즌 선택은 필수 항목입니다.")
        String season,

        @Min(value = 100, message = "등록 최소 금액이 100원 입니디.")
        int price,

        @NotBlank(message = "이미지 URI 필수 항목입니다.")
        String image,

        int discount,

        @NotEmpty(message = "사이즈 목록은 필수 항목입니다.")
        List<String> size,

        @NotEmpty(message = "색상 목록은 필수 항목입니다.")
        List<String> color
) {

}
