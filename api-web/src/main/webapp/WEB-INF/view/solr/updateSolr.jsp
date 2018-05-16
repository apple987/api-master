<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../inc/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html" charset="UTF-8">
	<title>修改solr</title>
</head>
  <body>
     <div style="margin-bottom: 10px">
	    <input type="button" value="返回" style="width: 80px; height: 30px; vertical-align: bottom; line-height: 10px;" class="btn-primary" onclick="solrBack()" /> 
		<input type="button" value="保存" style="width: 80px; height: 30px; vertical-align: bottom; line-height: 10px;" class="btn-primary" onclick="solrSave()" /> 
		<input type="button" value="取消" style="width: 80px; height: 30px; vertical-align: bottom; line-height: 10px;" class="btn-primary" onclick="solrCancle()" /> 
	 </div>
	 <div>
      <form id="solrUpdateFm" name="solrUpdateFm"  method="post" action="">
          <input type="hidden" name="id" value="${solr.id}"/>
          <table border="0" cellpadding="0"  cellspacing="0"
	         class="formlist" style="width: 100%; table-layout: fixed;">
                      <tr>
                            <th>价格</th>
                            <td><input id='price'  name='price' value='${solr.price}' style="width:168px;" class="{required:true,number:true}"/></td>
                            <th>标题</th>
                            <td><textarea id='title'  name='title' value='${solr.title}' style="width:168px;" class="{required:true,maxlength:2000}"  rows="2" >${solr.title}</textarea></td>
                      </tr>
                      <tr>
                            <th>称呼</th>
                            <td><textarea id='name'  name='name' value='${solr.name}' style="width:168px;" class="{required:true,maxlength:200}" rows="2" >${solr.name}</textarea></td>
                            <th>创建时间</th>
                            <td><input id='createtime'  name='createtime' readonly='true' style="width:168px;" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value='<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"  value="${solr.createtime}" />'/></td>
                      </tr>

          </table>
       </form>
     </div> 
     <script type="text/javascript">
       function solrSave(){//保存
          if($('#solrUpdateFm').valid()){//验证通过
				$.ajax({
					url: $.common.basePath+'/solr/update',
					contentType : "application/x-www-form-urlencoded; charset=UTF-8",
					datatype: 'json',
					type:"post",
					data:$('#solrUpdateFm').serializeObject(),
					success: function(json, status) {
						if(json==true){
							layer.msg('修改成功', {
				    				icon:1, 
								    time: 500,
								    end: function(index, layero){ 
								    	  parent.layer.close(parent.layer.getFrameIndex(window.name));  // 关闭layer
								          window.parent.location.reload(); //刷新父页面
										 //window.location.href=$.common.basePath+'/solr/init';
									}
							}); 
						}else{
						    layer.msg('修改失败', {
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
          $(':input','#solrUpdateFm') 
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
