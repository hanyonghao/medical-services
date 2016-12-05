<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="format-detection" content="telephone=no, email=no">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>社区公共卫生服务</title>
	<link href="${appPublic}/Base/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
	<link rel="stylesheet" href="${appPublic}/Base/css/base.css">
	<link rel="stylesheet" href="${appPublic}/Backstage/css/login.css">
</head>
<body>
<div class="wrapper">
	<div class="wrapper-container">
		<div class="login">
			<div class="login-head">社区公共卫生服务</div>
			<div class="login-body">
				<form id="login-form" class="login-form" method="post">
					<div class="form-group">
						<label class="form-label icon-user"></label>
						<div class="form-item">
							<input class="form-input" name="loginName" type="text" autocomplete="off" placeholder="请在此输入用户名..."/>
						</div>
					</div>
					<div class="form-group">
						<label class="form-label icon-lock"></label>
						<div class="form-item">
							<input class="form-input" name="password" type="password" autocomplete="off" placeholder="请在此输入密码..."/>
						</div>
					</div>
					<div class="form-submit">
						<button class="btn-submit" type="button">登录</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var appRoot = "${appRoot}";
	var appPath = "${appPath}";
	var appPublic = "${appPublic}";
</script>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Backstage/js/login.js"></script>
</body>
</html>