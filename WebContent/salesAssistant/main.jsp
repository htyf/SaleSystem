<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css" />
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/salesAssistant-main.js"></script>
</head>
<body>
	<!--添加和查找区域-->
	<div id="addAndSelet">
		<button id="addCustomerBtn">添加客户</button>
	</div>

	<!--数据展示区域-->
	<div id="showData">
		<table id="dg" class="easyui-datagrid"
			data-options="fitColumns:true,singleSelect:true,striped:true,pagination:true,rownumbers:true">
			<thead>
				<tr>
					<th data-options="field:'custId',width:130,align:'center'">编号</th>
					<th data-options="field:'custName',width:100,align:'center'">姓名</th>
					<th data-options="field:'custGender',width:100,align:'center'">性别</th>
					<th data-options="field:'custBirth',width:100,align:'center'">生日</th>
					<th data-options="field:'custEdu',width:100,align:'center'">学历</th>
					<th data-options="field:'custTel',width:100,align:'center'">电话</th>
					<th
						data-options="field:'custJonIntention',width:100,align:'center'">求职意向</th>
					<th data-options="field:'custSource',width:100,align:'center'">来源</th>
					<th data-options="field:'opra',width:150,align:'center'">操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>

	<!--添加数据区域-->
	<div id="addCustomer"
		style="display: none; width: 1000px; margin: 0px auto;">
		<a href="javascript:back();"
			style="text-decoration: none; color: black;">销售助理</a> 》添加客户
		<form id="ff" method="post"
			action="${pageContext.request.contextPath }/customer_add">
			<table style="width: 600px; margin: 20px auto;">
				<tr>
					<td>姓名</td>
					<td><input type="text" name="custName" /></td>
					<td>性别</td>
					<td><label><input type="radio" name="custGender"
							value="男" checked="checked" />男</label>&nbsp;&nbsp;&nbsp;&nbsp; <label><input
							type="radio" name="custGender" value="女" />女</label></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><select name="year" id="year"></select> <select
						name="month" id="month"></select> <select name="day" id="day"></select>
					</td>
					<td>籍贯</td>
					<td><input type="text" name="custNative" /></td>
				</tr>
				<tr>
					<td>学历</td>
					<td><input type="text" name="custEdu" /></td>
					<td>学校</td>
					<td><input type="text" name="custSchool" /></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" name='custTel' /></td>
					<td>邮箱</td>
					<td><input type="text" name="custEmail" /></td>
				</tr>
				<tr>
					<td>求职意向</td>
					<td><input type="text" name="custJonIntention" /></td>
					<td>来源</td>
					<td><input type="text" name="custSource" /></td>
				</tr>
				<tr>
					<td>家庭地址</td>
					<td colspan="3"><textarea name="custHA"
							style="width: 450px; height: 20px; resize: none;"></textarea></td>
				</tr>
				<tr>
					<td>备注</td>
					<td colspan="3"><textarea name="custComment"
							style="width: 450px; height: 50px; resize: none;"></textarea></td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
					<td><button type="submit" id="saveCustomer">保存</button>
						<button type="button" id="clear">清空</button>
						<button type="button" onclick="back();">返回</button></td>
				</tr>
			</table>
		</form>
	</div>

	<!--修改数据区域-->
	<div id="updateCustomer"
		style="display: none; width: 1000px; margin: 0px auto;">
		<a href="javascript:back();"
			style="text-decoration: none; color: black;">销售助理</a> 》修改客户
		<form id="ff" method="post"
			action="${pageContext.request.contextPath }/customer_update">
			<table style="width: 600px; margin: 20px auto;">
				<tr>
					<td><input type="hidden" name="custId" /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td><input type="text" name="custName" /></td>
					<td>性别</td>
					<td><label><input type="radio" name="custGender"
							value="男" checked="checked" />男</label>&nbsp;&nbsp;&nbsp;&nbsp; <label><input
							type="radio" name="custGender" value="女" />女</label></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><select name="year" id="year1"></select> <select
						name="month" id="month1"></select> <select name="day" id="day1"></select>
					</td>
					<td>籍贯</td>
					<td><input type="text" name="custNative" /></td>
				</tr>
				<tr>
					<td>学历</td>
					<td><input type="text" name="custEdu" /></td>
					<td>学校</td>
					<td><input type="text" name="custSchool" /></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" name='custTel' /></td>
					<td>邮箱</td>
					<td><input type="text" name="custEmail" /></td>
				</tr>
				<tr>
					<td>求职意向</td>
					<td><input type="text" name="custJonIntention" /></td>
					<td>来源</td>
					<td><input type="text" name="custSource" /></td>
				</tr>
				<tr>
					<td>家庭地址</td>
					<td colspan="3"><textarea name="custHA"
							style="width: 450px; height: 20px; resize: none;"></textarea></td>
				</tr>
				<tr>
					<td>备注</td>
					<td colspan="3"><textarea name="custComment"
							style="width: 450px; height: 50px; resize: none;"></textarea></td>
				</tr>
				<tr>
					<td colspan="3">&nbsp;</td>
					<td><button type="submit" id="updateCustomer">保存</button>
						<button type="button" id="clear">清空</button>
						<button type="button" onclick="back();">返回</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>