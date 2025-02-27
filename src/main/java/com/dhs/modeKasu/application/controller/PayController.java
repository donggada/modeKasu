package com.dhs.modeKasu.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/pay")
public class PayController {
    @Value("${toss.client.key}")
    private String key;

    @PostMapping("")
    public String pay() {
        return key;
    }

}
