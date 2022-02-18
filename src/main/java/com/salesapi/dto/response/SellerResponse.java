package com.salesapi.dto.response;

import com.salesapi.model.Seller;

public class SellerResponse {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static SellerResponse sellerResponseBuilder(Seller seller) {
		SellerResponse sellerResponse = new SellerResponse();
		sellerResponse.name  = seller.getName();
		return sellerResponse;
	}
}
