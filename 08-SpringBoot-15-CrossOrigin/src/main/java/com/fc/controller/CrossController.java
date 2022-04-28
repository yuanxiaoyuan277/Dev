package com.fc.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cross")
@CrossOrigin(originPatterns = "*", allowCredentials = "true",
        maxAge = 3600,methods = {
        RequestMethod.DELETE,
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.OPTIONS})
public class CrossController {
    @GetMapping("test")
    public String test(){
        return "成功";
    }
}
