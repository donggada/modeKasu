package com.dhs.modeKasu.domain.service;

import com.dhs.modeKasu.application.dto.request.LendItemRequest;
import com.dhs.modeKasu.domain.model.category.Category;
import com.dhs.modeKasu.domain.model.lendItem.LendItem;
import com.dhs.modeKasu.domain.model.lendItem.LendItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LendItemService {

    private final LendItemRepository lendItemRepository;

    public LendItem saveLendItem(LendItemRequest request, Category category) {
        return lendItemRepository.save(LendItem.createLendItem(request, category));
    }

    public List<LendItem> findLendItems() {
        return lendItemRepository.findAll();
    }
}
