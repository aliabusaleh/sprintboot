package com.exalt.sprintboot.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegexController {

    @GetMapping("/regex")
    String regex(){
        return "Ok";
    }
    @GetMapping("/regex/string/{name:[a-z]+}}")
    String regexString(@PathVariable("name") String name){
        return "path/{name}" +name;
    }
}
