$(function(){
	initData();
})


//返回按钮事件
var back=function(){
	$("#addAndSelet").show();
	$("#showData").show();
	$("#addCustomer").hide();
	$("#updateCustomer").hide();
}

//操作按钮事件
var oper=function(e){
	var customerId=$(e).parents("tr").children("td[field='custId']").text();
	var status=$(e).val();
	var data = {"custId":customerId,"custStatus":null,"custTime":null};
	updateStatus(data);
	$(e).parent().html("<label><input type='checkbox' name='statu' value='死单' onclick='statu(this);'/>死单</label>&nbsp;<label><input type='checkbox' name='statu' value='紧跟' onclick='statu(this);'/>紧跟</label>&nbsp;<label><input type='checkbox' name='statu' value='订座' onclick='statu(this);'/>订座</label>&nbsp;<label><input type='checkbox' name='statu' value='已报' onclick='statu(this);'/>已报</label>&nbsp;<label><input type='checkbox' name='statu' value='退费' onclick='statu(this);'/>退费</label>");
}
var statu=function(e){
	var customerId=$(e).parents("tr").children("td[field='customerId']").text();
	var status=$(e).val();
//	alert(customerId+":"+status+"      请输入备注");
	var data = {"custId":customerId,"custStatus":status,"custTime": getNowFormatDate()};
//	if(status=='上门'){
//		var param = prompt("请输入备注：","2017-3-2");
//		alert($("input[type=text]").val(param));
//		data = {"custId":customerId,"custStatus":status,"custTime": getNowFormatDate()};
//	}else if(status=='紧跟'){
//		var param = prompt("请输入备注：","2017-3-2");
//		alert($("input[type=text]").val(param));
//		data = {"custId":customerId,"custStatus":status,"custTime": $("input[type=text]").val(param)};
//	}
	updateStatus(data);
	
	$(e).parent().parent().html($(e).val()+"<button type='button' onclick='oper(this);'>操作</button>");
}

/**
 * 修改状态
 * @returns
 */
function updateStatus(datas){
	$.ajax({
		"url":getRootPath()+"/customer_updateStatus",
		"type":"POST",
		"dataType":"TEXT",
		"data":datas,
		"async":true,
		"success":function(data){
		},
		"error":function(){
			alert("update  error")
		}
	});
}

/**
 * 初始化咨询师数据
 * @returns
 */
function initData(){
	$("#showData tbody tr").remove();
	$.ajax({
		"url":"/SaleSystem/customer_getAllAskCust",
		"type":"post",
		"dataType":"json",
		"success":function(data){
			$.each(data,function(i,item){
				var d=new Date();
				d.setTime((item.custTime));
				var tr = "<tr>"+
				"<td>"+item.custId+"</td>"+
				"<td>"+item.custName+"</td>"+
				"<td>"+item.custTel+"</td>"+
				"<td>"+d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+"</td>"+
				"<td>上门<button type='button' onclick='oper(this);'>操作</button></td>"+
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


function queryByCondition(){
	if($("#selet input[name='select']").val()==''){
		alert("输入数据不能为空");
		$("#selet input[name='select']").val('');
		return;
	}
	
	$.ajax({
		"url":"/SaleSystem/customer_getAllAskCustByCondition",
		"type":"post",
		"dataType":"json",
		"data":{"condition":$("#cc option:selected").val(),"select":$("#selet input[name='select']").val()},
		"success":function(data){
			$("#showData tbody tr").remove();
			if(data==null||data==undefined||data==''){
				alert('没有查询到相关数据');
				$("#selet input[name='select']").val('');
			}else{
				$.each(data,function(i,item){
					var d=new Date();
					d.setTime((item.custTime));
					var tr = "<tr>"+
					"<td>"+item.custId+"</td>"+
					"<td>"+item.custName+"</td>"+
					"<td>"+item.custTel+"</td>"+
					"<td>"+d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate()+"</td>"+
					"<td>上门<button type='button' onclick='oper(this);'>操作</button></td>"+
					"</tr>";
					$("#showData tbody").append(tr);
				});
			}
			$("#selet input[name='select']").val('');
			$.parser.parse();//重绘界面  一定要有
		},
		"error":function(){
			alert("get data error! ")
		}
	});
}
/**
 * 获取当前时间
 * @returns
 */
function getNowFormatDate() {
	var date = new Date();
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var hour = date.getHours();
	var min = date.getMinutes();
	var sec = date.getSeconds();
	if (month >= 1 && month <= 9) {
		month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
		strDate = "0" + strDate;
	}
	if(hour >= 0 && hour <= 9){
		hour = "0"+hour;
	}
	if(min >= 0 && min <= 9){
		min = "0"+min;
	}
	if(sec >= 0 && sec <= 9){
		sec = "0"+sec;
	}
	var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	+ " " + hour + seperator2 + min+ seperator2 + sec;
	return currentdate;
} 

/**
 * 获取项目根路径
 * @returns
 */
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
