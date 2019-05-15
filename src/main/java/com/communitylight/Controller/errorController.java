package com.communitylight.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Septemberx
 * @Date: 2019/5/15 23:04
 */
@Controller
public class errorController {

    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
