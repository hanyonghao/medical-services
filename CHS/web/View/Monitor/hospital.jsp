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
	<link rel="stylesheet" href="${appPublic}/Monitor/css/hospital.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="hospital">

		<div class="hospital-head">
			<div class="hospital-title">医疗预约</div>
			<div class="btn-back icon-reply" onclick="history.go(-1);"></div>
			<div class="btn-order icon-time" onclick="window.location.href = '${appRoot}/Monitor/order'"></div>
		</div>
		<div class="hospital-body">
            <c:forEach items="${hospitals}" var="hospital">
                <div class="hospital-item" onclick="window.location.href = '${appRoot}/Monitor/doctor?hosId=${hospital.id}'">
                    <div class="hospital-item-left">
                        <img src="${appPublic}${hospital.img}" />
                    </div>
                    <div class="hospital-item-right">
                        <div class="hospital-item-right-name">${hospital.name}</div>
                        <div class="hospital-item-right-address">地址：${hospital.quarters}</div>
                    </div>
                </div>
            </c:forEach>
		</div>
	</div>
</div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
</body>
</html>