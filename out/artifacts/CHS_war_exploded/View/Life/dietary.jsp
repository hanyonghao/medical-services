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
	<link rel="stylesheet" href="${appPublic}/Life/css/dietary.css">
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
		<div class="control-item control-active" onclick="window.location.href = '${appRoot}/Life/dietary'">
			<p class="control-text">饮食推荐</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/movement'">
			<p class="control-text">运动建议</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/schedule'">
			<p class="control-text">生活作息</p>
		</div>
	</div>
	<div class="dietary">
		<div class="dietary-group">
			<div class="dietary-type">早餐</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/b_01.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">牛油果焗蛋</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">美容护肤</div>
			</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/b_02.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">卷心菜卷</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">清肠排毒</div>
			</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/b_03.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">棉花糖巧克力咖啡</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">美容养颜</div>
			</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/m_01.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">酸汤方便面</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">补充能量</div>
			</div>
		</div>
		<div class="dietary-group">
			<div class="dietary-type">午餐</div>
			<div class="dietary-item">
				<div class="dietary-img"><img src="${appPublic}/Life/img/l_01.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">自制食神叉烧饭</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">补中益气</div>
			</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/l_02.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">三鲜蛋饺煲</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">营养均衡</div>
			</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/l_03.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">酱烧鱼块</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">补脑益智</div>
			</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/m_02.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">老坛酸菜酱拌面</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">开胃生津</div>
			</div>
		</div>
		<div class="dietary-group">
			<div class="dietary-type">晚餐</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/d_01.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">素豆腐包</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">均衡营养</div>
			</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/d_02.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">手撕包菜</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">减肥瘦身</div>
			</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/d_03.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">凉拌土豆丝</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">延缓衰老</div>
			</div>
			<div class="dietary-item" onclick="window.location.href='${appRoot}/Index/newsContent'">
				<div class="dietary-img"><img src="${appPublic}/Life/img/m_03.jpg"></div>
				<div class="dietary-text">
					<div class="dietary-name">酸汤鲜肉馄饨</div>
					<div class="dietary-view icon-eye-open"> 0</div>
					<div class="dietary-good icon-thumbs-up"> 0</div>
				</div>
				<div class="dietary-efficacy">行气活血</div>
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
<script src="${appPublic}/Life/js/dietary.js"></script>
</body>
</html>