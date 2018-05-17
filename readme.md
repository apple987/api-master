api-master是springMVC项目，基于maven多模块依赖，采用dubbo远程调用，目前spring升级到4.3.13版本,欢迎大家提出意见,您的宝贵意见，是我们进步的动力。
 <br> 
 <br> 
**项目说明**<br>  
- 项目基于maven的多profile环境配置，打包时需要选择(test/pro/dev)打包运行的环境。<br>
<br>
**项目特点**<br>  
- 友好的代码结构及注释，便于阅读及二次开发 。<br>
- 前端页面采用jsp+freemaker，多视图解析处理，优先jsp。<br>
- 采用bootstrap-table强大灵活的表格插件渲染数据。 <br> 
- 后端配置swagger在线文档，方便编写API接口文档。<br> 
- 引入fastjson,redis配置。<br>
 <br> 
**项目结构**
<br>
api-master<br>
├─doc  (isec,wepull)项目SQL语句<br>
│<br>
├─api-web：web服务端,带有简单的页面显示<br>
│ <br>
├─api-facade：采用dubbo通讯服务,耦合api-web和api-provider模块<br>
│ <br>
├─api-provider: 依赖api-facade和api-service模块<br>
│ <br>
├─api-back：连接isec数据库的dao层<br>
│<br>
├─api-risk：连接wepull数据库的dao层<br>
│ <br>
├─api-service：事务控制,分布式事务，采用atomikos方式<br>
│ <br>
├─api-util：基础工具类，其他模块依赖此模块<br>
<br>
 **环境配置:**<br>
- 1.项目依赖zookeeper,redis工具。<br>
- 2.doc目录里面有初始化sql，运行项目前，请先创建mysql。<br>
- 3.工具地址:https://pan.baidu.com/s/1Bm7udGJc40xEENFgnJjsIw <br>
<br>
 **启动说明:**<br>
- 1.运行doc目录里面的sql文件，创建对应数据库isec,wepull<br>
- 2.启动redis6386单机,(密码:qdone)<br>
- 3.eclipse工具下，选中api-master节点，运行maven build:<br>
- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=blue>goals:clean install</font><br>
- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=blue>profile:test/pro/dev(三选一，必填)</font><br>
- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=blue>勾选 update snapshots和skip tests</font><br>
- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color=blue>执行run之后,拷贝target目录下mvc.war</font><br>
- 4.配置tomcat1,加入api-provider.war，启动tomcat1<br>
- 5.配置tomcat2,加入api-web.war，启动tomcat2<br>
- 6.访问http://localhost:ip:port/api-web/swagger-ui.html<br>
<br>     
## 效果图
![输入图片说明](https://git.oschina.net/uploads/images/2017/0604/194616_36ed7fd6_551203.png "在这里输入图片标题")
![](http://www.ityouknow.com/assets/images/keeppuresmile.jpg)	
 **用户反馈：**<br>
- Git仓库： https://github.com/apple987/api-master<br>
- 邮箱地址: m15171479289@163.com <br>
		
		

        