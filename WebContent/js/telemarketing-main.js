/**
 * 
 */

$(function(){
	initData();
	initMonthData()
});


//改变状态
var statu=function(e){
	var customerId=$(e).parents("tr").children("td[field='custId']").text();
	var status=$(e).val();
	alert(customerId+":"+status+"      请输入时间："+getNowFormatDate());
	var data = {"custId":customerId,"custStatus":status};
	if(status=='上门'){
		data = {"custId":customerId,"custStatus":status,"custTime":getNowFormatDate()};
	}else{
		data = {"custId":customerId,"custStatus":status,"custTime":getNowFormatDate()};
	}
	updateStatus(data);
	$(e).parent().parent().html($(e).val()+"&nbsp;&nbsp;&nbsp;&nbsp;<button type='button' onclick='update(this);'>修改</button>");
}
//修改状态
var update=function(e){
	var customerId=$(e).parents("tr").children("td[field='custId']").text();
	var status=$(e).val();
	var data = {"custId":customerId,"custStatus":null,"custTime":null};
	updateStatus(data);
	$(e).parent().html("<label><input type='checkbox' name='statu' value='无效' onclick='statu(this);'/>无效</label><label><input type='checkbox' name='statu' value='未通' onclick='statu(this);'/>未通</label><label><input type='checkbox' name='statu' value='死单' onclick='statu(this);'/>死单</label><label><input type='checkbox' name='statu' value='上门' onclick='statu(this);'/>上门</label><label><input type='checkbox' name='statu' value='紧跟' onclick='statu(this);'/>紧跟</label>");
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
 * 更新本月统计的数据
 * @returns
 */
function freshData(){
	$.ajax({
		"url":getRootPath()+"/customer_updateStatus",
		"type":"POST",
		"dataType":"TEXT",
		"data":datas,
		"success":function(data){
		},
		"error":function(){
			alert("update  error")
		}
	});
}

/**
 * 初始化数据
 * @returns
 */
function initData(){
	$.ajax({
		"url":"/SaleSystem/customer_getAllStatusNullCust",
		"type":"post",
		"dataType":"json",
		"success":function(data){
			$.each(data,function(i,item){
				var tr = "<tr>"+
				"<td>"+item.custId+"</td>"+
				"<td>"+item.custName+"</td>"+
				"<td>"+item.custTel+"</td>"+
				"<td>"+item.custJonIntention+"</td>"+
				"<td>"+item.custSource+"</td>"+
				"<td>"+
				"<label><input type='checkbox' name='statu' value='无效' onclick='statu(this);'/>无效</label>"+
				"<label><input type='checkbox' name='statu' value='未通' onclick='statu(this);'/>未通</label>"+
				"<label><input type='checkbox' name='statu' value='死单' onclick='statu(this);'/>死单</label>"+
				"<label><input type='checkbox' name='statu' value='上门' onclick='statu(this);'/>上门</label>"+
				"<label><input type='checkbox' name='statu' value='紧跟' onclick='statu(this);'/>紧跟</label>"+
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
 * 初始化本月统计的数据
 * @returns
 */
function initMonthData(){
	$("#countData tbody tr").remove();
	$.ajax({
		"url":"/SaleSystem/customer_getCurrMonthTotal",
		"type":"post",
		"dataType":"json",
		"success":function(data){
			var tr = "<tr>"+
			"<td>"+data.invalid+"</td>"+
			"<td>"+data.notpass+"</td>"+
			"<td>"+data.died+"</td>"+
			"<td>"+data.goin+"</td>"+
			"<td>"+data.forword+"</td>"+
			"<td>"+data.allocation+"</td>"+
			"</tr>";
			$("#countData tbody").append(tr);

			$.parser.parse();//重绘界面  一定要有
		},
		"error":function(){
			alert("get data error! ")
		}
	});

}
function refresh(){
	$("#showData tbody tr").remove();
	initData();
	initMonthData();
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

