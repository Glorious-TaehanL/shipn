package com.shipn.shipn.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.shipn.shipn.service.ApiService;
import com.shipn.shipn.service.ArticleService;

@RestController
public class ApiController {
	private final ApiService apiService;
	private final ArticleService articleService;
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);
	
	public ApiController(ApiService apiService,ArticleService articleService) {
		this.apiService = apiService;
		// TODO Auto-generated constructor stub
		this.articleService = articleService;
	}
	
//	@GetMapping("/api/v1/movies/{keyword}")
//	public ApiResponseDto get(@PathVariable String keyword) {
//		logger.info("[Controller] :: Api");		
//		return apiService.findByKeyword(keyword);
//	}
	
	@RequestMapping(value = "/api/v1/movies/{keyword}", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> gettt(@PathVariable String keyword) throws Exception {
		logger.info("[Controller] :: Api");
		return apiService.findByKeyword(keyword);
	}
	

	@RequestMapping(value = "/api/display/jqgrid.do", method = RequestMethod.POST)
	public Map<String, Object> searchGet(@RequestBody Map<String, Object> param,HttpServletRequest request, Model model ) throws Exception {
		logger.info("########## /users/post.do start ##########");
//		Map<String, Object> paramMap = new HashMap<String, Object>();
		Gson gson = new Gson();
		JsonParser jparser = new JsonParser();
//		   JsonElement elementItems = jparser.parse(request.getParameter("items"));
//		logger.info(elementItems.toString());
		logger.info("PLEASE");
		logger.info(param.toString());
		param.put("rows",param.get("items"));
		param.remove("items");
		logger.info(param.toString());
		Set<String> keySet = request.getParameterMap().keySet();
		for(String key: keySet) {
			logger.info(key + ": " + request.getParameter(key));
		}
		
		return param;
	}
	
	@RequestMapping(value = "/api/ups/valid/soinfo.do", method = RequestMethod.POST)
	@ResponseBody()
	public String upsValidCheck(@RequestBody  Map<String, Object> param , RedirectAttributes redirectAttributes) throws Exception{
		logger.info(param.toString());
		String validFlag = apiService.validCheck(param);
		redirectAttributes.addAttribute("validFlag", validFlag);
		
		return validFlag;

	}
	
	@RequestMapping(value = "/api/test/test", method = RequestMethod.GET)
	public Map<String, String> test(){
		Map<String, String> list = new HashMap<>();
		
		list.put("purpost", "only Test");
		logger.info(list.toString());
		return list;
	}
	
	@RequestMapping(value = "/users/pos.do")
	public String aaa(@RequestParam("articleNo")String no) throws Exception{
		logger.info("########## /users/pos.do start ##########");
		logger.info(no);
		
		return null;
	}
	
	
	
	@GetMapping("/rateTable.do")
	public @ResponseBody Map<String, Object> displayRateTable(){
		logger.info("display Rate Table");
		try {
			this.gettt("starwas");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
