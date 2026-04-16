package com.visa.dynalab.exam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {
    @GetMapping("/api/uppercase")
    public String toUpperCase(@RequestParam String name) {
        return name.toUpperCase();
    }
}
