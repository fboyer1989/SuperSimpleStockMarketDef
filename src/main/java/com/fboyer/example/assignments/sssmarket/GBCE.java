package com.fboyer.example.assignments.sssmarket;

import java.util.Map;

public class GBCE {

	/**
	 * This method calculates the shareIndex taking the sumatory of all the 
	 * prices of the stocks and the divide this results by the number of stocks
	 * 
	 * @param stocks
	 * @return GBE index
	 */
	public static Double allShareIndex(Map<String, Stock> stocks) {
		Double allShareIndex = 0.0;
		for(Stock stock: stocks.values()) {
			allShareIndex+=stock.getPrice();
		}
		return Math.pow(allShareIndex, 1.0 / stocks.size());
	}
	
}
