<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css"/>   
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css"/>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/counselor-main.js"></script>
</head>
<body>
	<!--添加和查找区域-->
	<div id="selet">
		<form>
			<select id="cc" style="width:100px;">    
			    <option value="custName">客户姓名</option>    
			    <option value="custTel">手机号码</option>   
			    <option value="custTime">上门日期</option>   
			</select> 
			<input type="text" name="select" />
			<input type="button" value="搜索" onclick="queryByCondition()"/>
		</form>
	</div>

	<!--数据展示区域-->
	<div id="showData">
		<table class="easyui-datagrid" data-options="fitColumns:true,singleSelect:true,striped:true,pagination:true,rownumbers:true">   
		    <thead>   
		        <tr>   
		            <th data-options="field:'custId',width:130,align:'center'">编号</th>   
		            <th data-options="field:'custName',width:100,align:'center'">客户姓名</th>  
		            <th data-options="field:'custTel',width:100,align:'center'">手机号码</th>
		            <th data-options="field:'custTime',width:100,align:'center'">上门日期</th>
		            <th data-options="field:'opra',width:150,align:'center'">状态</th>   
		        </tr>   
		    </thead>   
		    <tbody>   
		        <tr>   
		            <td>2017030513827463789</td>
		            <td>测试1</td>
		            <td>测试2</td>
		            <td>测试3</td>
		            <td>上门
		            	<button type="button" onclick="oper(this);">操作</button>
		            </td>   
		        </tr>   
		    </tbody>   
		</table> 
	</div>

	<!--刷新-->
	<div id="refresh" style="text-align:center;padding-top:20px;">
		<button type="button" onclick="initData()">刷新</button>
	</div>
</body>
</html>