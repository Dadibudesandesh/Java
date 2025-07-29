package com.example.WhetherApp.Service;

import com.example.WhetherApp.Model.WhetherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WhetherService {

    @Value("${openweathermap.api.url}")
    private String apiUrl;

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public WhetherResponse getResponse(String city) {
        String url = apiUrl + city + "&appid=" + apiKey;
        return restTemplate.getForObject(url, WhetherResponse.class);
    }

}
