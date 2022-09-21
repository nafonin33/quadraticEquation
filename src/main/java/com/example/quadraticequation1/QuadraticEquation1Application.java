package com.example.quadraticequation1;

import com.example.util.CalculateQuadraticEquation;
import com.example.util.ValueValidation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.regex.*;

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

       return new CalculateQuadraticEquation().calculate(a, b, c);
    }

}
