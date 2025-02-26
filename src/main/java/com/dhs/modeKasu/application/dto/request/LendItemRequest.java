package com.dhs.modeKasu.application.dto.request;

import java.util.List;

public record LendItemRequest(
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

}
