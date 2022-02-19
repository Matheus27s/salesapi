package com.salesapi.mocks;

import java.time.LocalDate;
import java.util.UUID;

import com.salesapi.dto.request.SaleRequest;
import com.salesapi.model.Sale;
import com.salesapi.model.Seller;

public class SaleMock {
	
	public static Sale getMock() {
		Sale sale = new Sale();
		sale.setId(UUID.randomUUID());
		sale.setDate(LocalDate.now());
		sale.setValue(100f);
		return sale;
	}
	
	public static SaleRequest getSaleRequestMock() {
		SaleRequest saleRequest = new SaleRequest();
		Sale sale = getMock();
		Seller seller = SellerMock.getMock();
		saleRequest.setDate(LocalDate.now().toString());
		saleRequest.setSellerName(seller.getName());
		saleRequest.setValue(sale.getValue());
		return saleRequest;
	}
	
	public static SaleRequest getSaleWithoutSellerMock() {
		SaleRequest saleRequest = new SaleRequest();
		Sale sale = getMock();
		saleRequest.setDate(LocalDate.now().toString());
		saleRequest.setValue(sale.getValue());
		return saleRequest;
	}
	
	public static SaleRequest getSaleWithNullMock() {
		SaleRequest saleRequest = new SaleRequest();
		return saleRequest;
	}
}
