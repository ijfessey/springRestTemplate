package com.fesco.reevoo;


import com.fesco.resttemplate.SpringRestTemplateBean;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by ian.fessey on 27/06/2016.
 */
public class ReevooRestTemplateTester {


    public static void main(String[] args) {
        System.out.println("In main , calling template");
        callReevooWithAuthentication();
    }

    private static void callReevooWithAuthentication() {

        String username = "NB3g5zWcTmLt1xRIJWgm4A";
        String password = "O-ac25oeKwqTuquo2VL6BTfrxVMT2WQ";

        // String httpsURL = "https://api.reevoocloud.com/v4/organisations/LRAU/reviewable?locale=en-AU&sku=ZZZ&format=short";
//        String httpsURL = "https://api.reevoocloud.com/v4/organisations/LRAU/reviewable?locale=en-AU&format=short";

        String httpsURL = "https://api.reevoocloud.com/v4/organisations/LRAU/reviewable?locale=en-AU&format=short";

        httpsURL = httpsURL + "&sku=" + "L538SV52016"; // TODO replace ZZZ with sku from the bean.


        HttpHeaders headers = createHeaders(username, password);


        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request = new HttpEntity<String>(headers);

        ReevooBean reevooBean = new ReevooBean();

        try {
            ResponseEntity<ReevooBean> response = restTemplate.exchange(httpsURL, HttpMethod.GET, request, ReevooBean.class);
            reevooBean = response.getBody();
        }
        catch (RestClientException rex) {
            System.out.println(rex.getMessage());
        }

        if (reevooBean != null) {
            System.out.println("Sku = " + reevooBean.getSku());
            System.out.println("Ave = " + reevooBean.getAverage_score());
            System.out.println("Revs = " + reevooBean.getReview_count());
        }
    }

    private static HttpHeaders createHeaders(final String username, final String password ){
        String plainCreds = username + ":" + password;
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        return headers;
    }
}
