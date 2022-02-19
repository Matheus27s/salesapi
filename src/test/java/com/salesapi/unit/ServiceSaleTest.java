package com.salesapi.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.salesapi.dto.request.SaleRequest;
import com.salesapi.mocks.SaleMock;
import com.salesapi.mocks.SellerMock;
import com.salesapi.model.Seller;
import com.salesapi.repository.SellerRepository;
import com.salesapi.service.SaleService;
import com.salesapi.service.SellerService;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServiceSaleTest {

	@Autowired
	@InjectMocks
	private SaleService service;
	
	@Mock
	private SellerService sellerService;
	
	@Mock
	private SellerRepository sellerRepository;
		
	@Test
	public void create_Success() {
		final SaleRequest saleRequestMock = SaleMock.getSaleRequestMock();
		final Seller sellerMock = SellerMock.getMock();
				
		doReturn(sellerMock).when(sellerRepository).findOneByName(saleRequestMock.getSellerName());
		ResponseEntity<?> response = service.create(saleRequestMock);
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void create_Error_SellerNotFound() {
		final SaleRequest saleRequestMock = SaleMock.getSaleWithoutSellerMock();	
		ResponseEntity<?> response = service.create(saleRequestMock);

		assertEquals(response.getStatusCode(), HttpStatus.BAD_REQUEST);
		assertEquals(response.getBody(), "Vendedor não encontrado.");
	}
}
