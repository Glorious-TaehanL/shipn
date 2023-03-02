package com.nouvolution.shipn41.dao;

import java.util.List;

import com.shipn.shipn.dto.ArticleVO;

public interface ArticleDAO {
	
	ArticleVO read(Integer articleNO) throws Exception;
	
	List<ArticleVO> listAll() throws Exception;
	
}
