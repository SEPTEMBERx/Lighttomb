package com.communitylight.Controller;

import com.communitylight.DTO.AccessTokenDTO;
import com.communitylight.DTO.GithubUserDTO;
import com.communitylight.Mapper.UserMapper;
import com.communitylight.Model.User;
import com.communitylight.support.GithubSupport;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: Septemberx
 * @Date: 2019/5/15 16:36
 */
@Controller
@MapperScan(basePackages = {"com.communitylight.Mapper"})
public class OauthController {

    @Autowired
    private GithubSupport githubSupport;

    @Autowired
    private UserMapper userMapper;

    @Value("${Github.Client_id}")
    private String ClientID;
    @Value("${Github.Client_secret}")
    private String ClientSecret;
    @Value("${Github.Redirect_uri}")
    private String RedirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state, HttpServletRequest request) {


        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(ClientID);
        accessTokenDTO.setClient_secret(ClientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(RedirectUri);
        String accessToken = githubSupport.getAccessToken(accessTokenDTO);

        GithubUserDTO githubUserDTO = null;

        try {
            githubUserDTO = githubSupport.getUser(accessToken);
            if (githubUserDTO != null) {

                User user = new User();

                user.setAccountId(String.valueOf(githubUserDTO.getId()));
                user.setUserName(githubUserDTO.getName());
                user.setGmtCreatetime(System.currentTimeMillis());
                user.setGmtModified(user.getGmtCreatetime());
                user.setCookie(UUID.randomUUID().toString());

                userMapper.insert(user);

                request.getSession().setAttribute("user", githubUserDTO);
//                登陆成功 写cookie 和 session
            } else {

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:http://localhost:8084/";
//                重定向到首页
    }
}

