package com.example.resource;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.AccountInfo;

@RestController
@RequestMapping(value = "/auth")
public class AuthorizeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizeController.class);

    @ResponseBody
	@RequestMapping(method=RequestMethod.GET,
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
					value="/{clientId}")
    public AccountInfo request(@PathVariable("clientId")String clientId, HttpServletRequest request) throws Exception{   
        LOGGER.info("remote:{}:{}", request.getRemoteAddr(), request.getRemotePort()); 
        return new AccountInfo(clientId, "00004165");
    }
    
}
