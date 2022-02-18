package com.salesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salesapi.dto.request.SaleRequest;
import com.salesapi.service.SaleService;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> create(@RequestBody SaleRequest saleRequestDTO) {
		return service.create(saleRequestDTO);
	}
}
