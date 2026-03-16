package com.harshit.traffic_system.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody Map<String,String> data){

        String username = data.get("username");
        String password = data.get("password");

        Map<String,String> response = new HashMap<>();

        if(username.equals("admin") && password.equals("1234")){

            response.put("status","success");

        }else{

            response.put("status","fail");

        }

        return response;
    }
}