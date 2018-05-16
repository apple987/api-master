<!doctype html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
	String path = request.getContextPath();
    String rootPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!-- set common webPath -->
<c:set var="root" scope="session" value="<%=basePath %>"/>
<c:set var="base" scope="session" value="<%=rootPath %>"/>
<!--  标题图标 -->
<link rel="Shortcut Icon" href="${root}/static/images/logo.ico" type="image/x-icon"/>
<link rel="stylesheet" href="${root}/static/plugins/bootstrap/css/bootstrap/bootstrap.css" type="text/css"></link>
<link rel="stylesheet" href="${root}/static/plugins/bootstrap/css/bootstrap-table.css" type="text/css"></link>
<link rel="stylesheet" href="${root}/static/css/common.css" type="text/css"></link>
<script type="text/javascript" src="${root}/static/js/jquery.js"></script>
<script type="text/javascript"src="${root}/static/plugins/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript"src="${root}/static/plugins/bootstrap/js/bootstrap-table.js"></script>	
<script type="text/javascript"src="${root}/static/plugins/bootstrap/js/bootstrap-table-zh-CN.js"></script> 
<!-- 基础工具JS -->
<script type="text/javascript"src="${root}/static/js/jquery.serializeObject.js"></script>
<script type="text/javascript"src="${root}/static/js/json2.js"></script>
 <!-- 多列排序  -->
<script type="text/javascript"src="${root}/static/plugins/bootstrap/js/bootstrap-table-multiple-sort.js"></script>
<!-- bootstrap-modal拖拽  -->
<link rel="stylesheet" href="${root}/static/plugins/bootstrap/drag/jquery-ui.css" type="text/css"></link> 
<script type="text/javascript"src="${root}/static/plugins/bootstrap/drag/jquery-ui.js"></script>
 <!-- 列宽度重置 -->
<script type="text/javascript" src="${root}/static/plugins/bootstrap/resize/bootstrap-table-resizable.js"></script>
<script type="text/javascript" src="${root}/static/plugins/bootstrap/resize/colResizable-1.5.source.js"></script>
<!-- 二维码  打印-->
<script src="${root}/static/plugins/bootstrap/qrcode/jquery.qrcode.min.js"></script>
<link rel="stylesheet" href="${root}/static/plugins/bootstrap/qrcode/PrintArea.css">
<script src="${root}/static/plugins/bootstrap/qrcode/jquery.PrintArea.js"></script>
 <!-- dialog框插件  -->
<link href="${root}/static/plugins/bootstrap/css/bootstrap-dialog.css" rel="stylesheet" type="text/css" />
<script src="${root}/static/plugins/bootstrap/js/bootstrap-dialog.js"></script> 
<!-- 单元格编辑插件 -->
<script src="${root}/static/plugins/bootstrap/editable/bootstrap-editable.js"></script>  
<script src="${root}/static/plugins/bootstrap/editable/bootstrap-table-editable.js"></script>
<!-- 导出  -->
<script src="${root}/static/plugins/bootstrap/export/tableExport.js"></script>
<script src="${root}/static/plugins/bootstrap/export/bootstrap-table-export.js"></script>
<script src="${root}/static/plugins/bootstrap/export/jquery.base64.js"></script>
<!-- 拖动列 -->
<script type="text/javascript" src="${root}/static/plugins/bootstrap/row/jquery.dragtable.js"></script>
<link rel="stylesheet" href="${root}/static/plugins/bootstrap/row/jquery.dragtable.css">
<script type="text/javascript" src="${root}/static/plugins/bootstrap/row/bootstrap-table-reorder-columns.js"></script>
<script src="${root}/static/js/common.js"></script>
<!-- echarts图标JS -->
<script src="${root}/static/plugins/echarts/echarts.js"></script>
<!-- 97日期插件 -->
<script src="${root}/static/plugins/my97/WdatePicker.js"></script>
<!-- layeDate日期插件 -->
<script src="${root}/static/plugins/laydate/laydate.js"></script>
<!-- 跨列选择 -->
<script type="text/javascript"src="${root}/static/plugins/bootstrap/js/lodash.js"></script>
<!-- select2 -->
<script type="text/javascript"src="${root}/static/plugins/select2/select2.js"></script>
<link rel="stylesheet" href="${root}/static/plugins/select2/select2.css">
<!-- 波纹效果 -->
<script type="text/javascript"src="${root}/static/plugins/waves/waves.min.js"></script>
<link rel="stylesheet" href="${root}/static/plugins/waves/waves.min.css">
<!-- tree  -->
<script type="text/javascript"src="${root}/static/plugins/bootstrap/treeview/bootstrap-treeview.js"></script>
<link rel="stylesheet" href="${root}/static/plugins/bootstrap/treeview/bootstrap-treeview.css">
<!-- 文件上传 -->
<script type="text/javascript"src="${root}/static/js/ajaxfileupload.js"></script>
<!-- layer弹出层 -->
<script type="text/javascript"src="${root}/static/plugins/layer/layer.js"></script>
<!-- form表单验证validate插件 -->
<script type="text/javascript"  src="${root}/static/plugins/validate/jquery.metadata.js"></script>  
<script type="text/javascript" src="${root}/static/plugins/validate/jquery.validate.js"></script>
<script type="text/javascript" src="${root}/static/plugins/validate/additional-methods.js"></script>
<!-- 动画效果 -->
<link rel="stylesheet" href="${root}/static/css/animate.css">
<!-- 字体样式 -->
<link rel="stylesheet" href="${root}/static/css/font-awesome.css">

