package com.king.service.impl;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.king.dao.back.core.BaseDao;
import com.king.dao.back.core.PageList;
import com.king.dao.back.model.Solr;
import com.king.dao.risk.core.RiskDao;
import com.king.service.SolrService;

import java.util.List;

/**
 * TODO 本代码由代码生成工具生成
 *
 * @author 付为地
 * @date 2017-09-21 01:44:38
 */

@Service("solrService")
public class SolrServiceImpl implements SolrService{

    static  Logger log=LoggerFactory.getLogger(SolrServiceImpl.class);
    
    /*@Resource(name = "baseDao")*/
    @Autowired
	private BaseDao baseDao;
    
    @Resource(name = "riskDao")
	private RiskDao riskDao;
	
	/**
	 * 分页查询
	 */
	@Override
	public PageList<Solr> selectPage(Solr object) {
	   log.info("执行SolrServiceImpl.selectPage参数：entity==>" +JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
       return baseDao.selectPage("com.king.dao.back.mapper.Solr.select", object);
	}

	/**
	 * 新增
	 */
	@Override
	public int insert(Solr object) {
		log.info("SolrServiceImpl.insert参数： entity=>" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
		com.king.dao.risk.model.Solr so=new com.king.dao.risk.model.Solr();
		so.setId(object.getId());
		so.setPrice(object.getPrice());
		so.setCreatetime(object.getCreatetime());
		so.setName(object.getName());
		riskDao.insert("com.king.dao.risk.mapper.Solr.insert", so);
        return baseDao.insert("com.king.dao.back.mapper.Solr.insert", object);
	}

	/**
	 * 修改
	 */
	@Override
	public int update(Solr object){
		log.info("执行SolrServiceImpl.update参数： entity==>" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
		com.king.dao.risk.model.Solr so=new com.king.dao.risk.model.Solr();
		so.setId(object.getId());
		so.setPrice(object.getPrice());
		so.setCreatetime(object.getCreatetime());
		so.setName(object.getName());
		riskDao.update("com.king.dao.risk.mapper.Solr.update", so);
		return baseDao.update("com.king.dao.back.mapper.Solr.update", object);
	}

	/**
	 * 浏览单个
	 */
	@Override
	public Solr view(String pk) {
		log.info("执行SolrServiceImpl.view参数： pk=>" + pk);
        return (Solr)baseDao.view("com.king.dao.back.mapper.Solr.view", pk);
	} 
	
    /**
	 * 查询单个
	 * @param object
	 * @return
	 */
	public Solr query(Solr object){
		log.info("执行SolrServiceImpl.query参数： entity=>" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
        return (Solr)baseDao.selectOne("com.king.dao.back.mapper.Solr.query", object);
	}
	 
    /**
	 * 查询集合
	 * @param object
	 * @return
	 */
	@Override
	public List<Solr> selectList(Solr object) {
		log.info("执行SolrServiceImpl.selectList参数： entity=>" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
        return baseDao.selectList("com.king.dao.back.mapper.Solr.select", object);
	}
	
    /**
	 * 删除
	 * @param pk
	 * @return
	 */
	@Override
	public int delete(String pk) {
		log.info("执行SolrServiceImpl.delete参数： pk=>" + pk);
		return baseDao.delete("com.king.dao.back.mapper.Solr.delete", pk);
	}
    /**
	 * 批量修改
	 * @param object
	 */
	@Override
	public int batchUpdate(List<Solr> object) {
		log.info("执行SolrServiceImpl.batchUpdate参数： List=>" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
		System.err.println("risk 删除："+riskDao.batchUpdate("com.king.dao.risk.mapper.Solr.batchUpdate", object));
		return baseDao.batchUpdate("com.king.dao.back.mapper.Solr.batchUpdate", object);
	}
	
    /**
	 * 批量插入
	 * @param object
	 */
	@Override
	public int batchInsert(List<Solr> object) {
	     log.info("执行SolrServiceImpl.batchInsert参数： List=>" + JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss"));
         return baseDao.batchInsert("com.king.dao.back.mapper.Solr.batchInsert", object);
	}
	
    /**
	 * 批量删除
	 */
	@Override
	public int batchDelete(List<Solr> pkList) {
		log.info("执行SolrServiceImpl.batchDelete参数： pkList=>" + JSON.toJSONStringWithDateFormat(pkList, "yyyy-MM-dd HH:mm:ss"));
        return baseDao.batchDelete("com.king.dao.back.mapper.Solr.batchDelete", pkList);
	}   
	
}
