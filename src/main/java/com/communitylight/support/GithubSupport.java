package com.communitylight.support;

import com.alibaba.fastjson.JSON;
import com.communitylight.DTO.AccessTokenDTO;
import com.communitylight.DTO.GithubUserDTO;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Author: Septemberx
 * @Date: 2019/5/15 16:44
 */
@Component
public class GithubSupport {

    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder().url("https://github.com/login/oauth/access_token").post(body).build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token =string.split("&")[0].split("=")[1];

                System.out.println(string);
            return token;
            } catch (IOException e) {
                e.printStackTrace();
            }

        return null;

    }

    public GithubUserDTO getUser(String accessTokenDTO) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url("https://api.github.com/user?access_token=" + accessTokenDTO).build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
//           将String 解析为JSON
            GithubUserDTO githubUserDTO = JSON.parseObject(string, GithubUserDTO.class);
            return githubUserDTO;
            } catch (IOException e) {
        }
        return null;
    }
}


