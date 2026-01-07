package com.personal.toolkit.controller;

import com.personal.toolkit.service.ZohoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZohoController {

    @Autowired
    private ZohoService zohoService;

    @GetMapping("/zoho/convertTime")
    public String convertTime(String inputTime) {
        return zohoService.calculateTimeLeft(inputTime);
    }

    @GetMapping("/zoho/sortString")
    public String sortString(String input) {
        return zohoService.sortString(input);
    }
}
