<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>海文办公系统</title>
	<link rel="stylesheet" type="text/css"
		href="easyui/themes/gray/easyui.css" />
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" />
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		var timerID = null;
		var timerRunning = false;
		function stopclock() {
			if (timerRunning)
				clearTimeout(timerID);
			timerRunning = false;
		}
		function startclock() {
			stopclock();
			showtime();
		}
		function showtime() {
			var now = new Date();
			var months = now.getMonth() + 1;
			var days = now.getDate();
			var hours = now.getHours();
			var minutes = now.getMinutes();
			var seconds = now.getSeconds()
			var timeValue = now.getFullYear()
			timeValue += "-" + months + "-" + days + " "
			timeValue += "" + ((hours >= 12) ? "下午 " : "上午 ")
			timeValue += ((hours > 12) ? hours - 12 : hours)
			timeValue += ((minutes < 10) ? ":0" : ":") + minutes
			timeValue += ((seconds < 10) ? ":0" : ":") + seconds
			document.getElementById("currentTime").innerHTML = timeValue;
			timerID = setTimeout("showtime()", 1000);
			timerRunning = true;
		}
		$(function() {
			showtime();
		});

		function change(data) {
			$("iframe").attr("src", data);
		}
	</script>
</head>
<body class="easyui-layout">
	<!--头部-->
	<div data-options="region:'north'"
		style="height: 110px; overflow: hidden; background: url(images/top.jpg) no-repeat; background-size: cover; padding-left: 70%; padding-top: 8px; font-size: 16px;"
		border="false">
		当前用户：张三&nbsp;&nbsp;|&nbsp;&nbsp;<a href="index.jsp"
			style="text-decoration: none; color: black;">退&nbsp;出</a><br><span
			id="currentTime">2017年3月4日</span>
	</div>
	<!--左侧导航栏-->
	<div data-options="region:'west'" style="width: 150px;" border="false">
		<div id="aa" class="easyui-accordion" fit="true" border="false">
			<div title="　销售业务" style="overflow: auto; padding: 10px;">
				<h3 style="color: #0099FF; text-align: center; background: #ccc;">
					<a href="javascript:change('salesAssistant/main.jsp');"
						style="text-decoration: none; color: black;">销售助理</a>
				</h3>
				<h3 style="color: #0099FF; text-align: center; background: #ccc;">
					<a href="javascript:change('networkConsulting/main.jsp');"
						style="text-decoration: none; color: black;">网络咨询</a>
				</h3>
				<h3 style="color: #0099FF; text-align: center; background: #ccc;">
					<a href="javascript:change('Telemarketing/main.jsp');"
						style="text-decoration: none; color: black;">电话销售</a>
				</h3>
				<h3 style="color: #0099FF; text-align: center; background: #ccc;">
					<a href="javascript:change('counselor/main.jsp');"
						style="text-decoration: none; color: black;">咨询师</a>
				</h3>
			</div>
			<div title="　部门主管" style="overflow: auto; padding: 10px;">
				<h3 style="color: #0099FF; text-align: center; background: #ccc;">
					<a href="javascript:change('manager/counselor/main.jsp');"
						style="text-decoration: none; color: black;">咨询师主管</a>
				</h3>
				<h3 style="color: #0099FF; text-align: center; background: #ccc;">
					<a href="javascript:change('manager/Telemarketing/main.jsp');"
						style="text-decoration: none; color: black;">电话销售主管</a>
				</h3>
				<h3 style="color: #0099FF; text-align: center; background: #ccc;">
					<a href="javascript:change('manager/networkConsulting/main.jsp');"
						style="text-decoration: none; color: black;">网络咨询主管</a>
				</h3>
			</div>
		</div>


	</div>
	<!--右侧内容栏-->
	<div data-options="region:'center'"
		style="padding: 5px; background: #eee;">
		<iframe src="wellcom.jsp" scrolling="auto" height="100%" width="100%"
			frameborder="0"></iframe>
	</div>
	<!--底部-->
	<div data-options="region:'south'"
		style="height: 160px; background: #333;" border="false">
		<div style='width: 600px; margin: 0 auto;'>
			<a href="#"
				style='color: #ccc; text-decoration: none; font-size: 14px; display: inline-block; margin-top: 20px; margin-right: 10px; margin-left: 120px;'>关于海文</a>
			<a href="#"
				style='color: #ccc; text-decoration: none; font-size: 14px; display: inline-block; margin-top: 20px; margin-right: 10px;'>联系海文</a>
			<a href="#"
				style='color: #ccc; text-decoration: none; font-size: 14px; display: inline-block; margin-top: 20px; margin-right: 10px;'>隐私申明</a>
			<a href="#"
				style='color: #ccc; text-decoration: none; font-size: 14px; display: inline-block; margin-top: 20px; margin-right: 10px;'>法律公告</a>
			<a href="#"
				style='color: #ccc; text-decoration: none; font-size: 14px; display: inline-block; margin-top: 20px; margin-right: 10px;'>部门介绍</a>
			<p
				style='font-size: 14px; color: #ccc; width: 600px; text-align: center;'>集团中心地址：上海市黄浦区北京东路668号科技京城G区6楼</p>
			<p
				style='font-size: 14px; color: #ccc; width: 600px; text-align: center;'>全国服务热线：400-156-8880
				全国监督及投诉邮箱：hs@oracleoaec.com</p>
		</div>
		<div
			style='width: 100%; background: #000; height: 35px; position: fixed; bottom: 0; text-align: center; color: #ccc; font-size: 14px; line-height: 35px;'>©
			版权所有 2016 上海海文信息技术有限公司 | 沪ICP备06010793号</div>
		<img src="images/weixin1.jpg" alt=""
			style='position: absolute; top: 15px; right: 140px;' />
	</div>
</body>
</html>