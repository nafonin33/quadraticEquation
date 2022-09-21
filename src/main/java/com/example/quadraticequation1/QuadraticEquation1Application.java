package com.example.quadraticequation1;

import com.example.util.CalculateQuadraticEquationImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class QuadraticEquation1Application {

    public static void main(String[] args) {
        SpringApplication.run(QuadraticEquation1Application.class, args);
    }

    @GetMapping("/equation")
    public String calculate(@RequestParam(value = "myA") String a,
                           @RequestParam( value = "myB") String b,
                           @RequestParam( value = "myC") String c) {

       return new CalculateQuadraticEquationImpl().calculate(a, b, c);
    }
}
