package com.fesco.resttemplate;


import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

/**
 * Created by ian.fessey on 27/06/2016.
 */
public class SpringRestTemplateTester {


    public static void main(String[] args) {
        System.out.println("In main , calling template");
        callSpringTemplateUrl();
    }

    private static void callSpringTemplateUrl() {


        // call test ip  http://ip.jsontest.com --> {"ip": "86.138.217.132"}
        RestTemplate restTemplate = new RestTemplate();
        SpringRestTemplateBean result = new SpringRestTemplateBean();
        result.setId("AAA-ZZZ");
        result.setIp("111.222.444");

        try {
            result = restTemplate.getForObject("http://ip.jsontest.com", SpringRestTemplateBean.class);
        }
        catch (RestClientException rex) {
            System.out.println(rex.getMessage());
        }

        System.out.println("Id = " + result.getId());
        System.out.println("Ip address = " + result.getIp());
    }

}
