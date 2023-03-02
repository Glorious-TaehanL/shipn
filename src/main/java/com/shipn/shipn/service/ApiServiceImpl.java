package com.shipn.shipn.service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shipn.shipn.api.ApiClient;
import com.shipn.shipn.dao.ShipmentInformationDAO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApiServiceImpl implements ApiService {
	private final ApiClient apiClient = new ApiClient();
	private static final Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);

	private ShipmentInformationDAO shipmentInformationDAO;

//	@Transactional(readOnly = true)
//	public ApiResponseDto findByKeyword(String keyword) {
//		return apiClient.requestMovie(keyword); 
//	}
//	@Transactional(readOnly = true)
	public ApiServiceImpl(ShipmentInformationDAO shipmentInformationDAO) {
		// TODO Auto-generated constructor stub
		this.shipmentInformationDAO = shipmentInformationDAO;
	}

	@Override
	public Map<String, Object> findByKeyword(String keyword) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", "");
		map.put("page", "");
		map.put("records", "");
		map.put("maplist", apiClient.requestMovie(keyword));

//		return apiClient.requestMovie(keyword);
		return map;
	}

	@Override
	public Map<String, Object> getCustomerShipmentAcc() {
		Map<String, Object> shipmentInfoMap = new HashMap<String, Object>();
		logger.info("INN getCustomerShipmentAcc FUNC ");
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) principal).getUsername();
		logger.info("current logrin session :: " + username);

		shipmentInfoMap = shipmentInformationDAO.getShipmentInforIdByUserId(username);

		logger.info(shipmentInfoMap.toString());

		return shipmentInfoMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String validCheck(Map<String, Object> param) {

		JSONObject tmpAJsonObj = new JSONObject();
		JSONObject tmpJsonObj = new JSONObject();
		JSONObject requestJson = new JSONObject();
		JSONParser jsonParse = new JSONParser();

		ObjectMapper obmapper = new ObjectMapper();
		String city, state, zip, accKey, userId, userPw, // parameter temporary object value
				tmpAddressJson, tmpRequiredRequest, // temporary Json request string.
				metaDataRequest, metaDataAddress, // metaData* = Json-String Object
				metaJsonAccRequest, metaJsonAVRequest, // metaJson* = Json Object
				requestJsonString; // Final json request value.

		Map<String, Object> shipmentInformationMap = new HashMap<String, Object>();
		Map<String, String> requestObjMap = new HashMap<String, String>();

		/** Mapping passed parameters to 'address' **/
		String[] streetArr = new String[2];
		streetArr[0] = param.get("to-street").toString();
		streetArr[1] = param.get("to-street2").toString();
		city = param.get("to-city").toString();
		state = param.get("to-state").toString();
		zip = param.get("to-zip").toString();

		tmpJsonObj.put("City", city);
		tmpJsonObj.put("StateProvinceCode", state);
		tmpJsonObj.put("PostalCode", zip);
		tmpAddressJson = "\"Address\":" + tmpJsonObj.toJSONString();
		/** 'address' mapping -end- **/

		tmpJsonObj = new JSONObject(); // init value
		tmpAJsonObj = new JSONObject(); // init value

		/** Initialize 'Required' request value mapping **/
		tmpJsonObj.put("CustomerContext", "");
		tmpAJsonObj.put("TransactionReference", tmpJsonObj);
		tmpJsonObj = new JSONObject(); // init value
		tmpAJsonObj.put("RequestAction", "AV");
		tmpRequiredRequest = "\"Request\":" + tmpAJsonObj.toJSONString();
		tmpAJsonObj = new JSONObject(); // init value
		/* logger.info("\"AddressValidationRequest\":{"+tmpRequiredRequest+","+ tmpAddressJson+"}"); -- check parameter json request --*/
		/** 'Required' mapping and init -end- **/

		/** Mapping passed parameters to 'shipinformation' **/
		shipmentInformationMap = this.getCustomerShipmentAcc();
		accKey = shipmentInformationMap.get("shipmentAccessKey").toString();
		userId = shipmentInformationMap.get("shipmentUserName").toString();
		userPw = shipmentInformationMap.get("shipmentUserPassword").toString();
		shipmentInformationMap.clear();
		
		tmpAJsonObj.put("AccessLicenseNumber", accKey);
		tmpAJsonObj.put("UserId", userId);
		tmpAJsonObj.put("Password", userPw);
		/** 'shipinformation' mapping and init -end- **/

		/** StringJson to JsonObject **/
		metaDataRequest = tmpRequiredRequest.replaceAll("&quot;", "\"");
		metaDataAddress = tmpAddressJson.replaceAll("&quot;", "\"");
		tmpJsonObj.put("AccessRequest", tmpAJsonObj);
		metaJsonAccRequest = "\"AccessRequest\":" + tmpAJsonObj;
		metaJsonAVRequest = "\"AddressValidationRequest\":{" + metaDataRequest + "," + metaDataAddress + "}";
		requestJsonString = "{" + metaJsonAccRequest + "," + metaJsonAVRequest + "}";
		/** -end- **/

		try {
			/** JsonObject to Map<String,String> **/
			requestJson = (JSONObject) jsonParse.parse(requestJsonString);
			requestObjMap = obmapper.convertValue(requestJson, Map.class);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			logger.error("JSON processing error :" + e);
		}
		
		return apiClient.validCheck(requestObjMap);
	}
}
