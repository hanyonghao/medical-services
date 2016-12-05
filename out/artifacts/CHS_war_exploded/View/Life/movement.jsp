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
	<link rel="stylesheet" href="${appPublic}/Life/css/movement.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="control">
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/guidance'">
			<p class="control-text">健康指导</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/dietary'">
			<p class="control-text">饮食推荐</p>
		</div>
		<div class="control-item control-active" onclick="window.location.href = '${appRoot}/Life/movement'">
			<p class="control-text">运动建议</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/schedule'">
			<p class="control-text">生活作息</p>
		</div>
	</div>
	<div class="movement">
		<div class="sport">
			<div class="sport-item sport-active" data-type="shoulder" style="border-right: 1px solid white;border-bottom: 1px solid white;">
				<img src="${appPublic}/Life/img/s_01.png">
				<p>肩部</p>
			</div>
			<div class="sport-item" data-type="chest" style="border-bottom: 1px solid white;">
				<img src="${appPublic}/Life/img/s_02.png">
				<p>胸部</p>
			</div>
			<div class="sport-item" data-type="arm" style="border-right: 1px solid white;">
				<img src="${appPublic}/Life/img/s_03.png">
				<p>手部</p>
			</div>
			<div class="sport-item" data-type="leg" >
				<img src="${appPublic}/Life/img/s_04.png">
				<p>腿部</p>
			</div>
		</div>
		<div id="shoulder" class="sport-tips">
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_03.png">
				<div class="tips-name">持续时间</div>
				<div class="tips-value">0.5小时</div>
			</div>
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_02.png">
				<div class="tips-name">速率</div>
				<div class="tips-value">30次/时</div>
			</div>
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_01.png">
				<div class="tips-name">提示</div>
				<div class="tips-value">注意肩部放松</div>
			</div>
		</div>
		<div id="chest" class="sport-tips" style="display: none;">
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_03.png">
				<div class="tips-name">持续时间</div>
				<div class="tips-value">0.4小时</div>
			</div>
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_02.png">
				<div class="tips-name">速率</div>
				<div class="tips-value">46次/时</div>
			</div>
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_01.png">
				<div class="tips-name">提示</div>
				<div class="tips-value">注意补水</div>
			</div>
		</div>
		<div id="arm" class="sport-tips" style="display: none;">
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_03.png">
				<div class="tips-name">持续时间</div>
				<div class="tips-value">1.5小时</div>
			</div>
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_02.png">
				<div class="tips-name">速率</div>
				<div class="tips-value">41次/时</div>
			</div>
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_01.png">
				<div class="tips-name">提示</div>
				<div class="tips-value">注意手臂抬高</div>
			</div>
		</div>
		<div id="leg" class="sport-tips" style="display: none;">
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_03.png">
				<div class="tips-name">持续时间</div>
				<div class="tips-value">0.8小时</div>
			</div>
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_02.png">
				<div class="tips-name">速率</div>
				<div class="tips-value">52次/时</div>
			</div>
			<div class="tips-item">
				<img src="${appPublic}/Life/img/t_01.png">
				<div class="tips-name">提示</div>
				<div class="tips-value">注意姿势</div>
			</div>
		</div>
	</div>
</div>
<div class="footer">
	<div class="menu">
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Index/index'">
			<p class="menu-ico icon-home"></p>
			<p class="menu-text">资讯</p>
		</div>
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Medical/index'">
			<p class="menu-ico icon-stethoscope"></p>
			<p class="menu-text">医疗</p>
		</div>
		<div class="menu-item text-active" onclick="window.location.href = '${appRoot}/Life/guidance'">
			<p class="menu-ico icon-dashboard"></p>
			<p class="menu-text">生活</p>
		</div>
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Mine/archives'">
			<p class="menu-ico icon-user"></p>
			<p class="menu-text">我</p>
		</div>
	</div>
</div>
<div class="btn-top icon-upload"></div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Base/js/base.js"></script>
<script src="${appPublic}/Life/js/movement.js"></script>
</body>
</html>