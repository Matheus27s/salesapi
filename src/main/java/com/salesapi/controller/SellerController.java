package com.salesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesapi.dto.request.SellerRequest;
import com.salesapi.service.SellerService;

@RestController
@RequestMapping(value = "/seller")
public class SellerController {
	
	@Autowired
	private SellerService service;
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> create(@RequestBody SellerRequest saleRequest) {
		return service.create(saleRequest);
	}
	
	@GetMapping(path = "/{start}/{end}", produces = "application/json")
	public ResponseEntity<?> findAllSeller(@PathVariable String start, @PathVariable String end) {
		return (ResponseEntity<?>) service.findAllSeller(start, end);
	}
}
