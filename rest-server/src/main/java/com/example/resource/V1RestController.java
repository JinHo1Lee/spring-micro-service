package com.example.resource;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.feign.AuthorizeService;
import com.example.feign.model.AccountInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/v1")
public class V1RestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(V1RestController.class);
    @Autowired
    private AuthorizeService authorizeService;
    
    @ResponseBody
	@RequestMapping(method=RequestMethod.POST,
					produces = MediaType.APPLICATION_JSON_VALUE,
					value="/hello")
    public ResponseEntity<Object> request(HttpServletRequest request) throws Exception{
        String clientId = "client_id";

        AccountInfo accountInfo = getAccountInfo(clientId);
        accountInfo.setClientId(clientId);
        
        ObjectMapper objectMapper = new ObjectMapper();
        LOGGER.info("remote:{}:[]", request.getRemoteAddr(), request.getRemotePort());
        return new ResponseEntity<>(objectMapper.writeValueAsString(accountInfo), HttpStatus.OK);
    }
    
    public AccountInfo getAccountInfo(String clientId){
        return authorizeService.getAccount(clientId);
    }
}
