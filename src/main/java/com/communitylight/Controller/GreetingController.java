package com.communitylight.Controller;

/**
 * @Author: Septemberx
 * @Date: 2019/5/15 10:28
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    //    The @GetMapping annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
    @GetMapping("/greeting")

    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}