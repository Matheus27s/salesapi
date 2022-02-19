package com.salesapi.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.salesapi.dto.request.SaleRequest;
import com.salesapi.dto.request.SellerRequest;
import com.salesapi.dto.response.SellerResponseDTO;
import com.salesapi.mocks.SaleMock;
import com.salesapi.mocks.SellerMock;
import com.salesapi.model.Seller;
import com.salesapi.repository.SellerRepository;
import com.salesapi.service.SaleService;
import com.salesapi.service.SellerService;
import com.salesapi.util.DataConvertionUtils;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServiceSellerTest {
	
	
	@Autowired
	@InjectMocks
	private SellerService service;

	@Mock
	private SaleService saleService;
	
	@Mock
	private SellerRepository repository;
		
	@Test
	public void create_Success() {
		SellerRequest sellerRequestMock = new SellerRequest();
		sellerRequestMock.setName("Maria");

		ResponseEntity<?> response = service.create(sellerRequestMock);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void findAllSeller_Success() {
		ResponseEntity<?> response = service.findAllSeller("2021-03-03","2021-03-06");
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void findAllSeller_Error() {
		ResponseEntity<?> response = service.findAllSeller("", "");
		
		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
		assertEquals(response.getBody(), "Erro ao listar vendedores.");
	}
}
