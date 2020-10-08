package com.exalt.sprintboot;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
 @GetMapping("/")
    public String home(){
     return "Hello, World! spring it  ";
 }
}
