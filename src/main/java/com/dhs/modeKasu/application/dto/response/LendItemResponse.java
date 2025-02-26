package com.dhs.modeKasu.application.dto.response;

import com.dhs.modeKasu.domain.model.lendItem.LendItem;
import lombok.Builder;

import java.util.List;

@Builder
public record LendItemResponse(
        Long index,
        String brand,
        String name,
        String category,
        String season,
        int price,
        String image,
        int discount,
        List<String> size,
        List<String> color
) {

    public static LendItemResponse of(LendItem lendItem) {
        return LendItemResponse.builder()
                .index(lendItem.getId())
                .brand(lendItem.getBrand())
                .name(lendItem.getName())
                .category(lendItem.getCategoryName())
                .season(lendItem.getSeason())
                .price(lendItem.getPrice())
                .image(lendItem.getImage())
                .discount(lendItem.getDiscount())
                .size(lendItem.getSize())
                .color(lendItem.getColor())
                .build();
    }
}
