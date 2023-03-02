package com.shipn.shipn.dao;

import java.util.Map;

public interface ShipmentInformationDAO {
	 Map<String, Object> getShipmentInforIdByUserId(String userId);
}
