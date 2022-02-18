package com.salesapi.dto.response;

import com.salesapi.model.Sale;
import com.salesapi.util.DataConvertionUtils;

public class SaleResponse {
	private String date;
	private Float value;
	
	public SaleResponse() {}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
	
	public static SaleResponse saleResponseBuilder(Sale sale) {
		SaleResponse saleResponse = new SaleResponse();
		saleResponse.date = DataConvertionUtils.convertDateToDayMonthYearFormat1(sale.getDate());
		saleResponse.value = sale.getValue();
		return saleResponse;
	}
}
