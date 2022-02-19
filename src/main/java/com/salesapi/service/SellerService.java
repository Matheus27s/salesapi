package com.salesapi.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.salesapi.dto.request.SellerRequest;
import com.salesapi.dto.response.SellerResponse;
import com.salesapi.dto.response.SellerResponseDTO;
import com.salesapi.model.Seller;
import com.salesapi.repository.SellerRepository;
import com.salesapi.util.DataConvertionUtils;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	
	public ResponseEntity<?> create(SellerRequest sellerRequest) {		
		try {
			Seller seller = new Seller();
			seller.setName(sellerRequest.getName());
			seller = repository.save(seller);		    
			return new ResponseEntity<SellerResponse>(SellerResponse.sellerResponseBuilder(seller), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A venda não pode ser criada.");
		}
	}

	public Seller findSeller(String sellerName) {
		return repository.findOneByName(sellerName);
	}
	
	public ResponseEntity<?> findAllSeller(String start, String end) {
		try {
			List<SellerResponseDTO> list = repository.findAllSeller(DataConvertionUtils.getLocalDate(start), DataConvertionUtils.getLocalDate(end));
			return new ResponseEntity<List<SellerResponseDTO>>(list, HttpStatus.OK);
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao listar vendedores.");
		}
	}

}
