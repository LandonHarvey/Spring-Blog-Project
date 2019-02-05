package com.codeup.springcodeupproject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class MathController {
    @GetMapping("/add/{addNumber}/and/{addNumber2}")
    @ResponseBody
    public int add(@PathVariable int addNumber, @PathVariable int addNumber2) {
       return addNumber + addNumber2;
    }
    @GetMapping("/subtract/{subNumber}/from/{subNumber2}")
    @ResponseBody
    public int sub(@PathVariable int subNumber, @PathVariable int subNumber2){
        return subNumber - subNumber2;
    }
    @GetMapping("/multiply/{multNumber}/from/{multNumber2}")
    @ResponseBody
    public int multiply(@PathVariable int multNumber, @PathVariable int multNumber2){
        return multNumber * multNumber2;
    }
    @GetMapping("/divide/{divNumber}/by/{divNumber2}")
    @ResponseBody
    public int divide(@PathVariable int divNumber, @PathVariable int divNumber2){
        return divNumber / divNumber2;
    }
}
