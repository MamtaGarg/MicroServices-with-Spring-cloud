package com.udemy.tutorial.microservices.currencyconversionservice.service;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.udemy.tutorial.microservices.currencyconversionservice.bean.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service", url="localhost:8000")
//@FeignClient(name="currency-exchange-service") // used to call currency-exchange-service
@FeignClient(name="netflix-zuul-api-gateway-server") // used to call currency-exchange-server through API Gateway
@RibbonClient(name="currency-exchange-service") // used for load balancing, can call any instance of currency-exchange-service
public interface CurrencyExchangeServiceProxy {

	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
	
}
