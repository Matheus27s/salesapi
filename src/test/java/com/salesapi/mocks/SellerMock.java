package com.salesapi.mocks;
import java.util.UUID;

import com.salesapi.model.Seller;

public class SellerMock {
	
	public static Seller getMock() {
		Seller seller = new Seller();
		seller.setId(UUID.randomUUID());
		seller.setName("Matheus Sousa");
		return seller;
	}

}
