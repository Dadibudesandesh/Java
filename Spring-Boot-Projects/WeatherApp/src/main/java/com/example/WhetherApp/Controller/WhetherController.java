package com.example.WhetherApp.Controller;


import com.example.WhetherApp.Model.WhetherResponse;
import com.example.WhetherApp.Service.WhetherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/whether")
public class WhetherController {

    @Autowired
    public WhetherService whetherService;

    @GetMapping("/{city}")
    public WhetherResponse get(@PathVariable("city") String city) {
        return whetherService.getResponse(city);
    }
}


