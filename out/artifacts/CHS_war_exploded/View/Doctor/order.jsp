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
	<link rel="stylesheet" href="${appPublic}/Doctor/css/order.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务 --- 医生端</div>
	</div>
	<div class="order">
        <c:forEach items="${orders}" var="order">
            <div class="order-item" data-value="${order.id}">
                <div class="order-item-left">
                    <img src="${appRoot}${order.userHead}" />
                </div>
                <div class="order-item-right">
                    <div class="order-user">
                        <span class="order-name">${order.userName}</span>
                        <span class="order-sex">${order.userSex}</span>
                        <span class="order-age">${order.userAge}岁</span>
                        <span class="order-status">${order.status}</span>
                        <span class="order-ico icon-pencil"></span>
                    </div>
                    <div class="order-date">预约时间：${order.orderDate}</div>
                    <div class="order-remark">概况描述：${order.remark}</div>
                </div>
            </div>
        </c:forEach>
	</div>
</div>
<div class="footer">
	<div class="menu">
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Doctor/index'">
			<p class="menu-ico icon-table"></p>
			<p class="menu-text">日程</p>
		</div>
		<div class="menu-item text-active" onclick="window.location.href = '${appRoot}/Doctor/order'">
			<p class="menu-ico icon-time"></p>
			<p class="menu-text">预约</p>
		</div>
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Doctor/reportList'">
			<p class="menu-ico icon-bar-chart"></p>
			<p class="menu-text">病历</p>
		</div>
	</div>
</div>
<div class="confirm confirm-order" style="display: none;">
	<div class="confirm-container">
		<div class="confirm-content">
			<div class="confirm-close icon-remove"></div>
			<div class="confirm-title">预约申请（<span></span>）</div>
			<div class="confirm-form">
				<form id="order-deal" method="post">
                    <input class="order-id" type="hidden" name="orderId" value="">
					<input class="confirm-input" type="text" name="feedback" autocomplete="off" placeholder="反馈">
					<button class="btn-submit btn-agree" type="button">同意</button>
					<button class="btn-submit btn-disagree" type="button" style="background: #c52619;">不同意</button>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="confirm confirm-finish" style="display: none;">
    <div class="confirm-container">
        <div class="confirm-content">
            <div class="confirm-close icon-remove"></div>
            <div class="confirm-title">诊疗确认（<span></span>）</div>
            <div class="confirm-form">
                <form id="order-confirm" method="post">
                    <input class="order-id" type="hidden" name="orderId" value="">
                    <input class="confirm-input" type="text" name="feedback" autocomplete="off" placeholder="反馈">
                    <button class="btn-submit btn-finish" type="button">同意</button>
                    <button class="btn-submit btn-cancel" type="button" style="background: #c52619;">不同意</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="btn-top icon-upload"></div>
<script type="text/javascript">
	var appRoot = "${appRoot}";
	var appPath = "${appPath}";
	var appPublic = "${appPublic}";
</script>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Base/js/base.js"></script>
<script src="${appPublic}/Doctor/js/order.js"></script>
</body>
</html>