package com.shipn.shipn.service;

import java.util.Map;

public interface ApiService {
	
	Map<String, Object> findByKeyword(String keyword);
	Map<String, Object> getCustomerShipmentAcc();
	String validCheck(Map<String, Object> param);
	
	
}
