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
	<link rel="stylesheet" href="${appPublic}/Monitor/css/doctor.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="doctor">
		<div class="doctor-head">
			<div class="doctor-title">医生预约</div>
			<div class="btn-back icon-reply" onclick="history.go(-1);"></div>
			<div class="btn-order icon-time" onclick="window.location.href = '${appRoot}/Monitor/order'"></div>
		</div>
		<div class="doctor-body">
			<c:forEach items="${doctors}" var="doctor">
				<div class="doctor-item" data-value="${doctor.id}" data-name="${doctor.name}">
					<div class="doctor-item-left">
						<img src="${appRoot}${doctor.head}" />
					</div>
					<div class="doctor-item-right">
						<div class="doctor-name">${doctor.name}<span class="doctor-num">（${doctor.num}）</span></div>
						<div class="doctor-mobile">手机号：${doctor.mobile}</div>
						<div class="doctor-tag">
							<c:forEach items="${doctor.tags}" var="tag">
								<div class="doctor-tag-item">${tag}</div>
							</c:forEach>
						</div>
						<div class="doctor-score">${doctor.point}分</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<div class="confirm" style="display: none;">
	<div class="confirm-container">
		<div class="confirm-content">
			<div class="confirm-close icon-remove"></div>
			<div class="confirm-title">添加预约</div>
			<div class="confirm-form">
				<form id="order-form" method="post">
                    <div class="doctor-choose">医生：<span></span></div>
                    <input class="doctor-id" type="hidden" name="doctorId" value="">
					<input class="confirm-input" type="date" name="orderDate" autocomplete="off" placeholder="预约日期">
					<input class="confirm-input" type="text" name="remark" autocomplete="off" placeholder="病情概述">
					<button class="btn-submit" type="button">添加</button>
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
<script src="${appPublic}/Monitor/js/doctor.js"></script>
</body>
</html>