package com.gig.springboot_concurrency_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jake
 * @date : 2022-03-15
 */
@RestController
@RequestMapping("/api/v1")
public class ConcurrencyRestController {

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello Concurrency api project");
    }
}
