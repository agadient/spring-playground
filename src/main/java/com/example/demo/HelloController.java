package com.example.demo;

import org.springframework.web.bind.annotation.*;

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
    public String calculate(@RequestParam Map querystring) {
        return new MathService().eval(querystring);
    }

    @PostMapping("/math/sum")
    public String sum(@RequestParam String[] n) {
        String result = "";
        Integer sum = 0;
        for (int i = 0; i < n.length-1; i++) {
            sum += Integer.parseInt(n[i]);
            result = result.concat(String.format("%s + ", n[i]));
        }
        sum += Integer.parseInt(n[n.length-1]);
        result = result.concat(String.format("%s = %d", n[n.length-1], sum));
        return result;
    }

    @RequestMapping("/math/volume/{l}/{w}/{h}")
    public String volume(@PathVariable int l, @PathVariable int w, @PathVariable int h) {
        return String.format("The volume of a %dx%dx%d rectangle is %d", l, w, h, l*w*h);
    }

    @PostMapping("/math/area")
    public String area(@RequestParam(value = "type", defaultValue = "circle") String type,
                       @RequestParam(value = "radius", defaultValue = "0") Integer radius,
                       @RequestParam(value = "length", defaultValue = "0") Integer len,
                       @RequestParam(value = "height", defaultValue = "0") Integer height) {
        String result = "";
        if (type.equals("circle")) {
            result = String.format("Area of a circle with a radius of %d is %.5f", radius,
                    Math.pow(radius, 2)*3.141592653589793);
        } else {
            result = String.format("Area of a %dx%d rectangle is %d", len, height, len*height);
        }
        return result;
    }


}