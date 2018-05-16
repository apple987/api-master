package com.king.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.king.common.util.Result;
import com.king.dao.back.model.Solr;
import com.king.dao.back.model.User;
import com.king.facade.SolrFacade;
import com.king.web.core.BaseController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags="测试接口",description = "简单测试Swagger接口")

@Controller
@RequestMapping("/user")
public class TestController extends BaseController {
	
	@Autowired
	private SolrFacade solrFacade;
	
	@RequestMapping(value = "/getSolr",method=RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "根据ID获取solr信息", httpMethod = "GET", notes = "传入ID查询对象", response = Solr.class)
	public Solr getSolr(
			@ApiParam(required = true, value = "Solr编号", name = "id") @RequestParam(value = "id") String id) {
		return solrFacade.view(id);
	}
	
	@ApiIgnore
	@RequestMapping(value = "/getUser",method=RequestMethod.GET)  
    @ResponseBody  
    @ApiOperation(value="根据ID获取用户信息",httpMethod="GET",notes="get user by id",response=Solr.class)  
    public Solr getUser(@ApiParam(required=true,value="用户ID",name="userId")@RequestParam(value="userId")Integer userId) {  
		return solrFacade.view(String.valueOf(userId)); 
    }  
	
	
	@RequestMapping(value = "/getInfo",method = {RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	@ApiOperation(value = "获取solr信息", httpMethod = "POST", notes = "ID查询对象", response = Solr.class,hidden=true)
	public Solr getInfo(
			@ApiParam(required = true, value = "编号", name = "id") @RequestParam(value = "id") String id) {
		return solrFacade.view(id);
	}
	
	@ApiOperation(value = "添加用户", notes = "获取商品信息(用于数据同步)", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	// @RequestBody只能有1个
	// 使用了@RequestBody，不能在拦截器中，获得流中的数据，再json转换，拦截器中，也不清楚数据的类型，无法转换成java对象
	// 只能手动调用方法
	public  Result<User> add(@ApiParam(name="用户对象",value="传入json格式",required=true) @RequestBody User user) {
		System.out.println(user);
		Result<User> usr=new Result<User>();
		User u=new User();
		u.setName("swagger测试");
        u.setPassword("123456");
        u.setSex(1);
        u.setToken("123456789");
        usr.setData(u);
		return usr;
	}
	
	
	// 列出某个类目的所有规格
		@ApiOperation(value = "获得用户列表", notes = "列表信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseBody
		@RequestMapping(value = "list", method = RequestMethod.POST)
		public Result<User> list(
				@ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId,
				@ApiParam(value = "分类ID", required = true) @RequestParam Long categoryId2,
				@ApiParam(value = "token", required = true) @RequestParam String token) {
			Result<User> result = new Result<User>();
			User u=new User();
			u.setName("swagger测试");
	        u.setPassword("123456");
	        u.setSex(1);
	        u.setToken("123456789");
	        result.setData(u);
			return result;
		}
}
