package com.rainie.restservice;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

        import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CalculatorController {

//    private static final String template = ["I am, %i!", "I am ", "I am "];

    @GetMapping("/api/calculation")
    public Calculator Calculator(@RequestParam Integer max, Integer divisor, Integer limit) {
        int a = max; int b = 0;
        int i = limit;
        ArrayList list = new ArrayList();
        while (a > 0 & i > 0) {
            b = a % divisor;
            if (b == 0) {
                list.add ("I am " + (a + 2));
                i--;
            }
            a--;
        }
        return new Calculator(String.format(String.valueOf(list)));
    }
}