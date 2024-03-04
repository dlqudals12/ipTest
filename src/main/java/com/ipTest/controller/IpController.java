package com.ipTest.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class IpController {

    @GetMapping("/ip")
    public ResponseEntity<HashMap<String, Object>> ipTest(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();

        String forward = request.getHeader("X-FORWARDED-FOR");
        String proxy = request.getHeader("Proxy-Client-IP");
        String client = request.getHeader("WL-Proxy-Client-IP");
        String remoteAddr = request.getRemoteAddr();

        result.put("forward", forward);
        result.put("proxy", proxy);
        result.put("client", client);
        result.put("remote", remoteAddr);

        return ResponseEntity.ok().body(result);
    }
 }
