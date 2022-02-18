package com.salesapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.salesapi.dto.request.SaleRequest;
import com.salesapi.dto.response.SaleResponse;
import com.salesapi.model.Sale;
import com.salesapi.repository.SaleRepository;
import com.salesapi.util.DataConvertionUtils;

@Service
public class SaleService {
	
	//@Autowired
	//private SellerService sellerService;
	
	@Autowired
	private SaleRepository repository;
	
	public ResponseEntity<?> create(SaleRequest saleRequest) {		
		try {
			//Seller seller = sellerService.findSeller(saleRequest.getSellerName());		
			
			//if(seller == null) {
			//	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendedor não encontrado.");
			//}
			
		    Sale sale = new Sale();	
		    sale.setDate(DataConvertionUtils.getLocalDate(saleRequest.getDate()));
		    sale.setValue(saleRequest.getValue());
		    //sale.setSeller(seller);
		    sale = repository.save(sale);		    
			return new ResponseEntity<SaleResponse>(SaleResponse.saleResponseBuilder(sale), HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A venda não pode ser criada.");
		}
	}
}
