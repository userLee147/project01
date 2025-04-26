package com.kh.boot.RESTController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/api/config")
public class APIConfigController{

    // xml에 있는 정보를 가져온다
    @Value("${google.login-api.client-id}")
    private String googleLoginApiClientId;
    @Value("${google.login-api.redirect-url}")
    private String googleLoginApiRedirectUrl;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ConfigResponse{
        private String clientId;
        private String redirectUrl;
    }

    @GetMapping(value = "/google/login", produces = "application/json; charset=UTF-8")
    public ConfigResponse getGoogleLoginConfig(){
        return new ConfigResponse(googleLoginApiClientId, googleLoginApiRedirectUrl);
    }




}