package com.dhs.modeKasu.application.controller;

import com.dhs.modeKasu.application.dto.request.LendItemRequest;
import com.dhs.modeKasu.application.dto.response.LendItemResponse;
import com.dhs.modeKasu.application.facade.LendItemFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lend-item")
public class LendController {

    private final LendItemFacade lendItemFacade;

    @PostMapping
    public LendItemResponse createLendItem(@Valid @RequestBody LendItemRequest request) {
        return lendItemFacade.createLendItem(request);
    }

    @GetMapping
    public List<LendItemResponse> findLendItems() {
        return lendItemFacade.findLendItems();
    }
}
