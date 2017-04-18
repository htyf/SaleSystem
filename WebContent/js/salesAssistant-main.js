/**
 * 
 */
$(function(){
	init();
	initData();
	paginationData();
	
});

function init(){
	//添加按钮
	$("#addCustomerBtn").bind("click",function(){
		$("#addAndSelet").hide();
		$("#showData").hide();
		$("#updateCustomer").hide();
		$("#addCustomer").show();
	});

	initdate("year","month","day");
}

//返回按钮事件
var back=function(){
	$("#addAndSelet").show();
	$("#showData").show();
	$("#addCustomer").hide();
	$("#updateCustomer").hide();
}

//修改按钮事件
var update=function(update){
	$("#addAndSelet").hide();
	$("#showData").hide();
	$("#updateCustomer").show();
	$("#addCustomer").hide();
	initdate("year1","month1","day1");
	//获取修改信息
	var customerId=$(update).parent().parent().siblings().first().text();
	$("#updateCustomer input[name='custId']").val(customerId);
	$.ajax({
		"url":getRootPath()+"/customer_getCustomerById",
		"type":"post",
		"dataType":"json",
		"data":{"custId":customerId},
		"success":function(data){
			$("#updateCustomer input[name='custName']").val(data.custName);
			$("#updateCustomer input[name='custNative']").val(data.custNative);
			$("#updateCustomer input[name='custEdu']").val(data.custEdu);
			$("#updateCustomer input[name='custSchool']").val(data.custSchool);
			$("#updateCustomer input[name='custTel']").val(data.custSchool);
			$("#updateCustomer input[name='custEmail']").val(data.custEmail);
			$("#updateCustomer input[name='custJonIntention']").val(data.custJonIntention);
			$("#updateCustomer input[name='custSource']").val(data.custSource);
			$("#updateCustomer textarea[name='custHA']").val(data.custHA);
			$("#updateCustomer textarea[name='custComment']").val(data.custComment);
			if(data.custGender=='女'){
				$("#updateCustomer input[name='custGender']").eq(1).attr("checked",true);
			}
			var arr = data.custBirth.split("-0");
			$("#updateCustomer select[name='year']").find("option[value='"+arr[0]+"']").attr("selected",true);
			$("#updateCustomer select[name='month']").find("option[value='"+arr[1]+"']").attr("selected",true);
			$("#updateCustomer select[name='day']").find("option[value='"+arr[2]+"']").attr("selected",true);
		}
	})
}

//删除按钮事件
var del=function(del){
	var customerId=$(del).parent().parent().siblings().first().text();
	alert(customerId);
	$.ajax({
		"url":getRootPath()+"/customer_delete",
		"type":"post",
		"data":{"custId":customerId},
		success:function(){
			window.location.reload("main.jsp");
		}
	});
//	window.location.href=getRootPath()+"/customer_delete?custId="+customerId;//刷新整个界面
	
}

//初始化年月日
function initdate(year,month,day){
	//初始化年月日
	for(var y=1980;y<=new Date().getFullYear();y++){
		$("#"+year).append("<option name='y' value='"+y+"''>"+y+"</option>");
	}	
	for(var m=1;m<=12;m++){
		$("#"+month).append("<option name='m' value='"+m+"''>"+m+"</option>");
	}
	for(var d=1;d<=31;d++){
		$("#"+day).append("<option name='d' value='"+d+"''>"+d+"</option>");
	}
}
function getRootPath() {
	// 获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	var curWwwPath = window.document.location.href;
	// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	// 获取主机地址，如： http://localhost:8083
	var localhostPaht = curWwwPath.substring(0, pos);
	// 获取带"/"的项目名，如：/uimcardprj
	var projectName = pathName
			.substring(0, pathName.substr(1).indexOf('/') + 1);
	return (localhostPaht + projectName);
}
/**
 * 获取初始化数据
 * @returns
 */
function initData(){
	$.ajax({
		"url":"/SaleSystem/customer_getAllCustomers",
		"type":"post",
		"dataType":"json",
		"success":function(data){
			$.each(data,function(i,item){
				var tr = "<tr>"+
				"<td>"+item.custId+"</td>"+
				"<td>"+item.custName+"</td>"+
				"<td>"+item.custGender+"</td>"+
				"<td>"+item.custBirth+"</td>"+
				"<td>"+item.custEdu+"</td>"+
				"<td>"+item.custTel+"</td>"+
				"<td>"+item.custJonIntention+"</td>"+
				"<td>"+item.custSource+"</td>"+
				"<td>" +
				"<button type='button' onclick='update(this);'>修改</button>" +
				"<button type='button' onclick='del(this);'>删除</button>" +
				"</td>"+
				"</tr>";
				$("#showData tbody").append(tr);
			});
			$.parser.parse();//重绘界面  一定要有
		},
		"error":function(){
			alert("get data error! ")
		}
	});
}

/**
 * 更改分页为中文
 */
function paginationData() {
	var p = $('#dg').datagrid('getPager');
	$(p).pagination({
		pageSize : 10,// 每页显示的记录条数，默认为10
		pageList : [ 10, 20, 50, 100 ],// 可以设置每页记录条数的列表
		beforePageText : '第',// 页数文本框前显示的汉字
		afterPageText : '页 共 {pages} 页',
		displayMsg : '当前显示 {from} - {to} 条记录 共 {total} 条记录',
	});
	$.parser.parse();
}

