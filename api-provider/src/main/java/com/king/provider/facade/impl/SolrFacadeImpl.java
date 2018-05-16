package com.king.provider.facade.impl;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.king.dao.back.core.PageList;
import com.king.dao.back.model.Solr;
import com.king.facade.SolrFacade;
import com.king.service.SolrService;

@Service("solrFacade")
public class SolrFacadeImpl implements SolrFacade{
	@Autowired
	private Properties apiUtil;
	@Autowired
	private Properties apiBack;
	
	@Autowired
	private SolrService solrService;

	@Override
	public PageList<Solr> selectPage(Solr entity) {
		System.err.println("SolrFacadeImpl api util"+apiUtil);
		System.err.println("SolrFacadeImpl api back"+apiBack);
		return solrService.selectPage(entity);
	}

	@Override
	public int insert(Solr object) {
		return solrService.insert(object);
	}

	@Override
	public int update(Solr object) {
		return solrService.update(object);
	}

	@Override
	public Solr view(String pk) {
		return solrService.view(pk);
	}

	@Override
	public Solr query(Solr object) {
		return solrService.query(object);
	}

	@Override
	public List<Solr> selectList(Solr object) {
		return solrService.selectList(object);
	}

	@Override
	public int delete(String pk) {
		return solrService.delete(pk);
	}

	@Override
	public int batchUpdate(List<Solr> arr) {
		return solrService.batchUpdate(arr);
	}

	@Override
	public int batchInsert(List<Solr> arr) {
		return solrService.batchInsert(arr);
	}

	@Override
	public int batchDelete(List<Solr> pkList) {
		return solrService.batchDelete(pkList);
	}
	
	
}
