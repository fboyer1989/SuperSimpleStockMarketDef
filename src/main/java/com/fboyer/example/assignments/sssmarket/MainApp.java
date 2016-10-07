package com.fboyer.example.assignments.sssmarket;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fboyer.example.assignments.sssmarket.enums.StockType;

public class MainApp 
{
	private static Log log = LogFactory.getLog(MainApp.class);

    public static void main( String[] args ) {
        try {         
        	//load datas 
    		Map<String, Stock> db = loadDB();
            for (Stock stock: db.values()) {
                // Run dividend and P/E Ratio routines
            	log.info( stock.getSymbol() + " dividend: " + stock.dividend(9.1));
            	log.info( stock.getSymbol() + " P/E Ratio: " + stock.PERatio(9.1));
            	Integer rangeMin = 1;
        		Integer rangeMax = 10;
        		double randomValue=0;
        		
                // Record some trades
            	for (int i=1; i <= 10; i++) {
            		Random r = new Random();
            		randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            		stock.buy(i, randomValue);
            		log.info( stock.getSymbol() + " bought " + i + " shares at $" + randomValue);
            		randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            		stock.sell(i, randomValue);
            		log.info( stock.getSymbol() + " sold " + i + " shares at $" + randomValue);
            	}
            	log.info( stock.getSymbol() + " price: $" + stock.getPrice());
            	log.info( stock.getSymbol() + " volumeWeightedStockPrice: $" + stock.calculateVolumeWeightedStockPrice());
            }
            Double GBCEallShareIndex = GBCE.allShareIndex(db);
            log.info( "GBCE All Share Index: " + GBCEallShareIndex);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
    }
   
    /**
     * Load datas for the example
     * 
     * @return Map<String,Stock> with all the datas 
     */
    public static Map<String, Stock> loadDB(){
    	 HashMap<String, Stock> db = new HashMap<String, Stock>();
         db.put("TEA", new Stock("TEA", StockType.COMMON, 0.0, 0.0, 100.0));
         db.put("POP", new Stock("POP", StockType.COMMON, 8.0, 0.0, 100.0));
         db.put("ALE", new Stock("ALE", StockType.COMMON, 23.0, 0.0, 60.0));
         db.put("GIN", new Stock("GIN", StockType.PREFERRED, 8.0, 0.2, 100.0));
         db.put("JOE", new Stock("JOE", StockType.COMMON, 13.0, 0.0, 250.0));
         return db;
    }
    
}
