package com.king.web.controller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.king.common.util.Function;
import com.king.common.util.SerialNo;
import com.king.dao.back.model.Solr;
import com.king.facade.SolrFacade;
import com.king.web.core.BaseController;

/**
 * solr管理
 * 
 * @付为地
 * @date 2017-09-21 01:59:19
 */
@Controller
@RequestMapping("/solr")
public class SolrController extends BaseController {

	@Autowired
	private SolrFacade solrFacade;
	@Autowired
	private Properties apiUtil;
	@Autowired
	private Properties apiBack;
	@Value("#{configProperties['system.run.info']}")  
	private String name;
	

	/**
	 * 页面初始化
	 */
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public String init(){
		System.err.println("SolrController api-util:"+apiUtil);
		System.err.println("SolrController api-back:"+apiBack);
		System.err.println(name);
		return "solr/selectSolr";
	}

	/**
	 * 分页查询数据
	 * @throws InterruptedException 
	 */
	@RequestMapping(value = "/selectPage", method = RequestMethod.POST)
	@ResponseBody
	@Function("solr分页")
	public Map<String, Object> selectPage(@RequestBody Solr entity) throws InterruptedException {
		return responseSelectPage(solrFacade.selectPage(entity));
	}

	/**
	 * 跳转添加
	 */
	@RequestMapping(value = "/preInsert", method = RequestMethod.GET)
	public String preInsert(HttpServletRequest req) {
		return "solr/insertSolr";
	}

	/**
	 * 添加数据
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.PUT)
	@ResponseBody
	@Function("solr添加")
	public Boolean insert(@RequestBody Solr entity) {
		entity.setId(SerialNo.getUNID());
		return solrFacade.insert(entity) > 0 ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * 跳转更新
	 */
	@RequestMapping(value = "/preUpdate", method = RequestMethod.GET)
	public String preUpdate(HttpServletRequest request) {
		request.setAttribute("solr", solrFacade.view(request.getParameter("id")));
		return "solr/updateSolr";
	}

	/**
	 * 更新数据
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	@Function("solr更新")
	public Boolean update(Solr entity) {
		return solrFacade.update(entity) > 0 ? Boolean.TRUE : Boolean.FALSE;
	}

	/**
	 * 删除数据
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	@Function("solr删除")
	public Boolean delete(@RequestBody List<Solr> ids) {
		return solrFacade.batchDelete(ids) > 0 ? Boolean.TRUE : Boolean.FALSE;
	}


	
}
