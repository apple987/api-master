<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html" charset="UTF-8">
	<title>添加solr</title>
</head>
  <body>
  <div class="container">
     <div style="margin-bottom: 10px">
	    <input type="button" value="返回" style="width: 80px; height: 30px; vertical-align: bottom; line-height: 10px;" class="btn-primary" onclick="solrBack()" /> 
		<input type="button" value="保存" style="width: 80px; height: 30px; vertical-align: bottom; line-height: 10px;" class="btn-primary" onclick="solrSave()" /> 
		<input type="button" value="取消" style="width: 80px; height: 30px; vertical-align: bottom; line-height: 10px;" class="btn-primary" onclick="solrCancle()" /> 
	 </div>
	 <div>
      <form id="solrInsertFm" name="solrInsertFm"  method="post" action="">
          <table border="0" cellpadding="0" id="solrInsertTable" cellspacing="0"
			 class="formlist" style="width: 100%; table-layout: fixed;">
                      <tr>
                            <th>价格</th>
                            <!-- <td><input id='price'  name='price' class="{required:true,number:true}" style="width:168px;"/></td> -->
                            <td><input id='price'  name='price' style="width:168px;"/></td>
                            <th>标题</th>
                            <td><textarea id='title'  name='title' class="{required:true,maxlength:2000}" rows="2" style="width:168px;"></textarea></td>
                      </tr>
                      <tr>
                            <th>称呼</th>
                            <td><textarea id='name'  name='name' class="{required:true,maxlength:200}"  rows="2" style="width:168px;"></textarea></td>
                            <th>创建时间</th>
                            <td><input id='createtime'  name='createtime' readonly='true' onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" style="width:168px;"/></td>
                      </tr>

          </table>
       </form>
     </div> 
 </div> 
     <script type="text/javascript">
       function solrSave(){//保存
          if($('#solrInsertFm').valid()){//验证通过
				$.ajax({
					url: $.common.basePath+'/solr/insert',
					contentType:"application/json",
			    	dataType : "json",
			    	type : "put",
	                data : JSON.stringify($('#solrInsertFm').serializeObject()), 
					success: function(json, status) {
						if(json==true){
							layer.msg('添加成功', {
				    				icon:1, 
								    time: 500,
								    end: function(index, layero){ 
								         parent.layer.close(parent.layer.getFrameIndex(window.name));  // 关闭layer
								    	 window.parent.location.reload(); //刷新父页面
										 //window.location.href=$.common.basePath+'/solr/init';
									}
							}); 
						}else{
						    layer.msg('添加失败', {
			    				icon:5, 
							    time: 500,
							    end: function(index, layero){ 
							         parent.layer.close(parent.layer.getFrameIndex(window.name));  // 关闭layer
								     window.parent.location.reload(); //刷新父页面
									 //window.location.href=$.common.basePath+'/solr/init';
								}
						    });
						}
					},
					error: function(json, status) {
					    layer.msg('系统异常,请稍后重试或联系技术人员', {
		    				icon:5, 
						    time: 1500,
						    end: function(index, layero){ 
								 parent.layer.close(parent.layer.getFrameIndex(window.name));  // 关闭layer
								 window.parent.location.reload(); //刷新父页面
								 //window.location.href=$.common.basePath+'/solr/init';
							}
					    });
					}
				});
		  }
       }
       function solrCancle(){//取消
          $(':input','#solrInsertFm') 
			    .not(':button, :submit, :reset, :hidden') 
			    .val('') 
			    .removeAttr('checked') 
			    .removeAttr('selected');
       }
       function solrBack(){//返回
          parent.layer.close(parent.layer.getFrameIndex(window.name));  // 关闭layer
		  window.parent.location.reload(); //刷新父页面
          //window.location.href=$.common.basePath+'/solr/init';
       }
     </script>
  </body>
</html>
