package com.example.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.feign.model.AccountInfo;

@FeignClient(value = "auth-server")
public interface AuthorizeService {

    @Cacheable(value="accountCache")
	@RequestMapping(path = "/auth/{clientId}", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public AccountInfo getAccount(@PathVariable("clientId") String clientId);
}
