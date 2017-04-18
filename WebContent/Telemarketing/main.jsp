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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/telemarketing-main.js"></script>
</head>
<body>
	<!--数据展示操作区域-->
	<div id="showData">
		<table class="easyui-datagrid" data-options="fitColumns:true,singleSelect:true,striped:true,pagination:true,rownumbers:true">   
		    <thead>   
		        <tr>   
		            <th data-options="field:'custId',width:100,align:'center'">编号</th>   
		            <th data-options="field:'custName',width:60,align:'center'">姓名</th>  
		            <th data-options="field:'custGender',width:100,align:'center'">电话</th>
		            <th data-options="field:'custJobIntention',width:100,align:'center'">求职意向</th>
		            <th data-options="field:'custBirth',width:100,align:'center'">来源</th>  
		            <th data-options="field:'opra',width:150,align:'center'">状态</th>   
		        </tr>   
		    </thead>   
		    <tbody>   
		         
		    </tbody>   
		</table> 
	</div>
	
	<!--刷新-->
	<div id="refresh" style="text-align:center;padding-top:20px;">
		<button type="button" onclick="refresh()">刷新</button>
	</div>
	<!--本月统计-->
	<div>本月统计</div>
	<div id="countData">
		<table class="easyui-datagrid" data-options="fitColumns:true,singleSelect:true,striped:true">   
		    <thead>   
		        <tr>   
		            <th data-options="field:'custId',width:100,align:'center'">无效电话</th>
		            <th data-options="field:'custName',width:100,align:'center'">未通电话</th>  
		            <th data-options="field:'custGender',width:100,align:'center'">死单</th>
		            <th data-options="field:'custJobIntention',width:100,align:'center'">上门</th>
		            <th data-options="field:'custBirth',width:100,align:'center'">紧跟</th>
		            <th data-options="field:'monthCount',width:100,align:'center'">分配</th>   
		        </tr>   
		    </thead>   
		    <tbody>   
		        <tr>   
		            <td>5435</td>
		            <td>33</td>
		            <td>444</td>
		            <td>543</td> 
		            <td>32</td>
		            <td>5453</td>
		        </tr>   
		    </tbody>   
		</table> 
	</div>
</body>
</html>