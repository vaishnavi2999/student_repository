package net.javaguides.springboot.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {


    @GetMapping("/hello-world")
    public String helloWorld()
    {
        return "Hello, World!";
    }
}
