package com.nouvolution.shipn41.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nouvolution.shipn41.dto.ApiResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApiClient {
	private static final Logger logger = LoggerFactory.getLogger(ApiClient.class);
	private final RestTemplate restTemplate = new RestTemplate();
	private final String CLIENT_ID = "BpfrI4PpvwGavcbSbTvO"; // private id.
	private final String CLIENT_SECRET = "JjnxskdJwr"; // private secret key.
	private final String OpenNaverMovieUrl_getMovies = "https://openapi.naver.com/v1/search/movie.json?query={keyword}";

	private final String UPS_CLIENT_ACCESSNO = "BCD64D4DA5752BA5";
	private final String UPS_CLIENT_NAME = "solemio";
	private final String UPS_CLIENT_PASSWORD = "1hNuGKI2aj";
	private final String UPS_VALIDCHECK_URL = "https://onlinetools.ups.com/rest/AV";

	public ApiResponseDto requestMovie(String keyword) {
		final HttpHeaders headers = new HttpHeaders();
		headers.set("X-Naver-Client-Id", CLIENT_ID);
		headers.set("X-Naver-Client-Secret", CLIENT_SECRET);
		final HttpEntity<String> entity = new HttpEntity<>(headers);

		return restTemplate.exchange(OpenNaverMovieUrl_getMovies, HttpMethod.GET, entity, ApiResponseDto.class, keyword)
				.getBody();
	}

	public String validCheck(Map<String, String> param) {

		String validFlag = null;
		final HttpHeaders headers = new HttpHeaders();
		headers.set("AccessLicenseNumber", UPS_CLIENT_ACCESSNO);
		headers.set("Username", UPS_CLIENT_NAME);
		headers.set("Password", UPS_CLIENT_PASSWORD);
		final HttpEntity<Map<String, String>> entity = new HttpEntity<>(param);
		
		ResponseEntity<String> requestContainer = restTemplate.postForEntity(UPS_VALIDCHECK_URL, entity, String.class);
		logger.info(requestContainer.getBody());

		try {
			ObjectMapper mapper = new ObjectMapper();
			String myJson = requestContainer.getBody();
			JsonNode myJsonNode = mapper.readTree(myJson);
			
			if(myJsonNode.isObject()) {
				ObjectNode obj = (ObjectNode)myJsonNode;

				if(obj.has("AddressValidationResponse")) {
					JsonNode valueResponse = obj.get("AddressValidationResponse").get("Response");
					String responseCodeValue = valueResponse.findValue("ResponseStatusCode").toString();
					String str_responseCodeValue = responseCodeValue.replaceAll("\\\"","");
					
					if(str_responseCodeValue.equals("1")) {
						validFlag = "Success Valid Check";
					}else {
						validFlag = "Please check Ship to address";
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("IOException :: UPS VALIDATION CHECK PROGRESS");
			logger.error("Sales Order Information is not correct");
			logger.error(e.toString());
		}

		return validFlag;
	}
}
