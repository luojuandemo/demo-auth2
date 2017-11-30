package com.smyw.demoauth2.web;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestEndpoints {

    @Autowired
    private RedisTokenStore redisTokenStore;

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "product id : " + id;
    }

    @GetMapping("/user/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "认证Token", required = true, dataType = "string", paramType = "header")})
    public String getUser(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "user id : " + id;
    }




    @GetMapping("/order/{id}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "authorization", value = "认证Token", required = true, dataType = "string", paramType = "header")})
    public String getOrder(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof UserDetails) {
            UserDetails userDeatils = (UserDetails) obj;
            return userDeatils.getPassword() + userDeatils.getUsername();
        } else {
            return null;
        }
    }
    @GetMapping("/logout")
    public String logout(String token){
        redisTokenStore.removeAccessToken(token);
        return "Ok";
    }
//
//    @PostMapping("/oauth/token")
//    public String token() {
//        //for debug
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return "order id : " + 1;
//    }


}