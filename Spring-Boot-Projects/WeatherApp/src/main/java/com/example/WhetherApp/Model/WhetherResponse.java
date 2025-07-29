package com.example.WhetherApp.Model;

import lombok.Data;

import java.util.List;

@Data
public class WhetherResponse {

    private Main main;
    private List<Weather> Weather;
    private Wind wind;

    @Data
    public static class Main {
        private Double temp;
        private int humidity;
        private Long pressure;
    }

    @Data
    public static class Weather {
        private String main;
        private String description;
    }


    @Data
    public static class Wind {
        private Double speed;
        private Long deg;
    }


}
