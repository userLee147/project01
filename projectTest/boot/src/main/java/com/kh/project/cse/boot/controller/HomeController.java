package com.kh.project.cse.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("test.main")
    public String main() {
        return "common/main";
    }
    @GetMapping("test.pos")
    public String pos() {
        return "common/pos";
    }

}
