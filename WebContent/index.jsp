<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>海文办公系统</title>
	<link type="text/css" rel="stylesheet"	href="css/css_1.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div id="login">

		<div id="login-header-wrap">
			<div id="login-header">
				<ul class="menu">
					<li class="first">海文办公系统</li>
				</ul>
			</div>
		</div>

		<div id="login-main">
			<div id="login-content">

				<div id="content-left">
					<div id="login-left-img">
						<img src="images/login-banner.png">
					</div>
				</div>
				<div id="login-line"></div>

				<div id="login-window-warp">
		
					<div id="login-window">
						<div id="logo">
							<img src="images/logo.png">
						</div>
						<div class="region region-content">
							<div id="block-system-main" class="block block-system">
								<div class="content">
								
								<!-- 提交数据 -->
									<form action="main.jsp" method="post" id="user-login">
											<div class="form-item form-type-textfield form-item-name">
													<input	id="edit-name" name="name" size="60" maxlength="60"
													class="form-text required" type="text">
											</div>
											<div class="form-item form-type-password form-item-pass">
												<input
													id="edit-pass" name="password" size="60" maxlength="128"
													class="form-text required" type="password">
											</div>
											<div class="form-actions form-wrapper" id="edit-actions">
												<input id="edit-submit" name="op" value="登录"
													class="form-submit" type="submit">
											</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>

		<div id="login-footer-wrap">
			<div id="login-footer">
				<span>甲骨文OAEC人才产业基地</span><span>电话：021-61050790</span><span>地址：上海市黄浦区天津路180号应氏大厦16层</span><span>邮编：200001</span>
			</div>
		</div>
	</div>
</body>
</html>