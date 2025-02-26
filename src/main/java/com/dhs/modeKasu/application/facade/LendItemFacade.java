package com.dhs.modeKasu.application.facade;

import com.dhs.modeKasu.application.dto.request.LendItemRequest;
import com.dhs.modeKasu.application.dto.response.LendItemResponse;
import com.dhs.modeKasu.domain.service.CategoryService;
import com.dhs.modeKasu.domain.service.LendItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LendItemFacade {

    private final LendItemService lendItemService;
    private final CategoryService categoryService;

    public LendItemResponse createLendItem(LendItemRequest request) {
        return LendItemResponse.of(
                lendItemService.saveLendItem(
                        request,
                        categoryService.findCategory(request.categoryId())
                )
        );
    }

    public List<LendItemResponse> findLendItems() {
        return lendItemService.findLendItems().stream().map(LendItemResponse::of).toList();
    }
}
