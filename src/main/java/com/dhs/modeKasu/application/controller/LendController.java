package com.dhs.modeKasu.application.controller;

import com.dhs.modeKasu.application.dto.request.LendItemRequest;
import com.dhs.modeKasu.application.dto.response.LendItemResponse;
import com.dhs.modeKasu.application.facade.LendItemFacade;
import com.dhs.modeKasu.domain.model.category.Category;
import com.dhs.modeKasu.domain.model.category.CategoryRepository;
import com.dhs.modeKasu.domain.model.lendItem.LendItem;
import com.dhs.modeKasu.domain.model.lendItem.LendItemRepository;
import com.dhs.modeKasu.domain.service.CategoryService;
import com.dhs.modeKasu.domain.service.LendItemService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/lend-item")
public class LendController {

    private final LendItemFacade lendItemFacade;
    private final LendItemRepository lendItemRepository;
    private final CategoryRepository categoryRepository;

    @PostMapping
    public LendItemResponse createLendItem(@RequestBody @Valid LendItemRequest request) {
        return lendItemFacade.createLendItem(request);
    }

    @GetMapping
    public List<LendItemResponse> findLendItems() {
        return lendItemFacade.findLendItems();
    }

    @GetMapping("/mock")
    @Transactional
    public List<LendItemResponse> mock() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 파일을 읽어서 List<LendItem> 객체로 변환
            List<LendItem> lendItems = objectMapper.readValue(
                    new File("/Users/gimdongmin/Downloads/modeKasu/src/main/resources/static/list.JSON"),
                    new TypeReference<List<LendItem>>() {
                    }
            );

            List<Category> list = lendItems.stream().map(LendItem::getCategory)
                    .collect(Collectors.collectingAndThen(
                            Collectors.toMap(Category::getName, category -> category, (existing, replacement) -> existing, LinkedHashMap::new),
                            map -> new ArrayList<>(map.values())
                    ));

            List<Category> categories = categoryRepository.saveAll(list);

            Map<String, List<Category>> collect = categories.stream().collect(Collectors.groupingBy(Category::getName));
            for (LendItem itme : lendItems) {
                itme.setId(null);
                itme.setCategory(collect.get(itme.getCategoryName()).get(0));
            }

            lendItemRepository.saveAll(lendItems);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("에러");
        }
        return List.of();
    }
}
