package com.example.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.GrpcClientService;


@RestController
public class V1RestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(V1RestController.class);

    @Autowired
    private GrpcClientService grpcClientService;

    @RequestMapping("/")
    public String printMessage(@RequestParam(defaultValue = "Michael") final String name) {
        return this.grpcClientService.hello(name).getName();
    }
}
