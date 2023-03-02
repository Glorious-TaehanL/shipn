package com.shipn.shipn.service;

import java.util.List;

import com.shipn.shipn.dto.ArticleVO;

public interface ArticleService {

	ArticleVO read(Integer articleNO) throws Exception;
	
	List<ArticleVO> listAll() throws Exception;
	
}
