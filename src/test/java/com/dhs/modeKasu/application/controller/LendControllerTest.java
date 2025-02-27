package com.dhs.modeKasu.application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
class LendControllerTest {

    @Autowired
    LendController lendController;

    @Test
    void test() throws IOException {
        lendController.mock();
    }
}