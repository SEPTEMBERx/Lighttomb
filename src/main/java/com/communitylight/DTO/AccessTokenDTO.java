package com.communitylight.DTO;



import lombok.*;

/**
 * @Author: Septemberx
 * @Date: 2019/5/15 16:46
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenDTO {

    @Getter @Setter private String client_id;
    @Getter @Setter private String client_secret;
    @Getter @Setter private String code;
    @Getter @Setter private String redirect_uri;
    @Getter @Setter private String state;

}
