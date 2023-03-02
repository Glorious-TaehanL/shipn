package com.shipn.shipn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shipn.shipn.dao.ArticleDAO;
import com.shipn.shipn.dto.ArticleVO;

@Service
public class ArticleServiceImpl implements ArticleService {

	private final ArticleDAO articleDAO;
	
	public ArticleServiceImpl(ArticleDAO articleDAO) {
		// TODO Auto-generated constructor stub
		this.articleDAO = articleDAO;
	}

	@Override
	public ArticleVO read(Integer articleNO) throws Exception {
		// TODO Auto-generated method stub
		return articleDAO.read(articleNO);
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return articleDAO.listAll();
	}

}
