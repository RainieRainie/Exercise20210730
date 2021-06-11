package com.rainie.restservice;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController2 {

//    private static final String template = ["I am, %i!", "I am ", "I am "];

    @PostMapping("/api/calculation2")

    public Calculator2 Calculator2(@RequestBody JsonReq content){
        //private int max;
       int a = content.getMax();
        /*public int max;
        int a = content.max;*/
        int b = 0;
        //private int limit;
        int i = content.getLimit();
        /*public int limit;
        int i = content.limit; */
        ArrayList list = new ArrayList();
        while (a > 0 & i > 0) {
            //private int limit;
            b = a % content.getDivisor();
            /*public int limit;
            b = a % content.divisor;*/
            if (b == 0) {
                list.add ("I am " + (a + 2));
                i--;
            }
            a--;
    }
        return new Calculator2(String.format(String.valueOf(list)));
    }
}