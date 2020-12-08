package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring!";
    }

    @GetMapping("/math/pi")
    public String pi() {
        return "3.141592653589793!";
    }

    @GetMapping("/math/calculate")
    public Map calculate(@RequestParam Map querystring) {
        String operation = "";
        if (querystring.containsKey("operation")) {
            operation = (String) querystring.get("operation");
        }
        Integer x = 1;
        Integer y = 1;
        if (querystring.containsKey("x")) {
            x = Integer.parseInt((String) querystring.get("x"));
        }

        if (querystring.containsKey("y")) {
            y = Integer.parseInt((String) querystring.get("y"));
        }
        String result = "";
        if (operation.equals("subtract")) {
            result = String.format("%d - %d = %d", x, y, x-y);
        } else if (operation.equals("multiply")) {
            result = String.format("%d * %d = %d", x, y, x*y);
        } else if (operation.equals("divide")) {
            result = String.format("%d / %d = %d", x, y, x/y);
        } else {
            result = String.format("%d + %d = %d", x, y, x+y);
        }
        return querystring;
    }


}