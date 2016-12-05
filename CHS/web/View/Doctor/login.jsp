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
	<title>社区公共卫生服务 --- 医生端</title>
	<link href="${appPublic}/Base/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
	<link rel="stylesheet" href="${appPublic}/Base/css/base.css">
	<link rel="stylesheet" href="${appPublic}/Doctor/css/login.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务 --- 医生端</div>
	</div>
	<div class="login">
		<div class="logo">
			<img src="${appPublic}/Doctor/img/logo_smail.png">
		</div>
		<div class="login-form">
			<form id="login-form" method="post">
				<div class="form-group">
					<label class="form-label icon-user"></label>
					<div class="form-item">
						<input class="form-input" type="text" name="loginName" autocomplete="off" placeholder="请在此输入用户名..."/>
					</div>
				</div>
				<div class="form-group">
					<label class="form-label icon-lock"></label>
					<div class="form-item">
						<input class="form-input" type="password" name="password" autocomplete="off" placeholder="请在此输入密码..."/>
					</div>
				</div>
				<div class="form-submit">
					<button class="btn-submit" type="button">登录</button>
				</div>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	var appRoot = "${appRoot}";
	var appPath = "${appPath}";
	var appPublic = "${appPublic}";
</script>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Doctor/js/login.js"></script>
</body>
</html>