<%@ page language="java" contentType="text/html;charset=Utf-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/common.jsp"%>
<head>
<title>错误页面</title>
</head>
<div class="error-content" style="padding: 50px;text-align:center;">
	<h3>非常抱歉！系统资源不存在</h3><br>
	如有疑问请联系我们的客服人员或研发人员，我们会尽快帮您解决<br><br>
	<button onclick="goBack()">返回</button>
</div>
<script type="text/javascript">
function goBack(){
	window.parent.location.href="${root}/";
}
</script>








