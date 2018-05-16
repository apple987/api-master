<%@ page language="java" contentType="text/html;charset=Utf-8"
    pageEncoding="UTF-8"%>
<%@ include file="../inc/common.jsp"%>
<head>
<title>错误页面</title>
<script language="javascript">
	$(function(){
		$('#error-msg').hide();
		$('#toggle-error').on('click', function(){
			$('#error-msg').toggle();
		});
		$('#back').on('click', function(){
			$('.error-content').hide();
			window.parent.location.href="${root}/";
		});
	})
	function showDetail(){
		$('#detail_error_msg').toggle();
	}
</script>
</head>
<div class="error-content" style="padding: 50px;text-align:center;">
	<h1>非常抱歉！系统发生错误</h1><br>
	<font size="3">请把错误信息发送给我们的客服人员或研发人员，我们会尽快帮您解决</font><br><br>
	<button id="back" >返回主页</button>&nbsp;&nbsp;&nbsp;
	<button >信息反馈</button><br><br>
	<p><a  href="#" id="toggle-error">查看错误详情</a></p>
	<div id="error-msg" >
		错误状态: ${result.status} <br>
		错误信息: ${result.message}
	</div>
</div>







