package com.communitylight.Controller;

import com.communitylight.Mapper.UserMapper;
import com.communitylight.Model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Septemberx
 * @Date: 2019/5/15 15:34
 */
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookielist = request.getCookies();
        String cookie=request.getHeader("cookie");
        for (Cookie coo : cookielist) {
            if (coo.getName().equals("token")) {
                String token = coo.getValue();
                User user = userMapper.findByToken(token);

                if (user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }


        return "index";
    }
}
