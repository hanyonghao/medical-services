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
	<link rel="stylesheet" href="${appPublic}/Monitor/css/order.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="order">
		<div class="order-head">
			<div class="order-title">预约记录</div>
			<div class="btn-back icon-reply" onclick="history.go(-1);"></div>
		</div>
		<div class="order-body">
			<c:forEach items="${orders}" var="order">
				<div class="order-item" data-value="${order.id}">
					<div class="order-item-left">
						<img src="${appRoot}${order.doctorHead}" />
					</div>
					<div class="order-item-right">
						<div class="order-item-right-name">${order.doctorName}<span class="doctor-num">（${order.doctorNum}）</span></div>
						<div class="order-item-right-value">所属：${order.hospitalName}</div>
						<div class="order-item-right-value">时间：${order.orderDate}</div>
						<div class="order-item-right-value order-status">进度：${order.status}</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<script type="text/javascript">
    var appRoot = "${appRoot}";
    var appPath = "${appPath}";
    var appPublic = "${appPublic}";
</script>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Monitor/js/order.js"></script>
</body>
</html>