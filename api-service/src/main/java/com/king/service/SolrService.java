package com.king.service;

import java.util.List;

import com.king.dao.back.core.PageList;
import com.king.dao.back.model.Solr;

/**
 * TODO 本代码由代码生成工具生成
 *
 * @author 付为地
 * @date 2017-09-21 01:44:38
 */

public interface SolrService {

	/**
	 * 分页查询
	 * @param entity
	 * @return
	 */
	public PageList<Solr> selectPage(Solr entity);
	
	/**
	 * 新增
	 * @param object
	 * @return
	 */
	public int insert(Solr object) ;
	
	/**
	 * 修改
	 * @param object
	 * @return
	 */
	public int update(Solr object)  ;
	
	/**
	 * 查看
	 * @param pk
	 * @return
	 */
	public Solr view(String pk) ;
	
	/**
	 * 查询单个
	 * @param object
	 * @return
	 */
	public Solr query(Solr object) ;
	
	/**
	 * 查询集合
	 * @param object
	 * @return
	 */
	public List<Solr> selectList(Solr object) ;
	
	/**
	 * 删除
	 * @param pk
	 * @return
	 */
	public int delete(String pk);
	
	/**
	 * 批量修改
	 * @param object
	 */
	public int batchUpdate(List<Solr> arr);
	
	/**
	 * 批量插入
	 * @param object
	 */
	public int batchInsert(List<Solr> arr);
	
	/**
	 * 批量删除
	 */
	public int batchDelete(List<Solr> pkList);
}
