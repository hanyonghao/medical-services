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
	<link rel="stylesheet" href="${appPublic}/Message/css/message.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="message">
		<div class="message-head">
			<div class="message-title">消息</div>
			<div class="btn-back icon-reply" onclick="history.go(-1);"></div>
		</div>
		<div class="message-body">
			<c:forEach items="${messages}" var="message">
				<div class="message-item">
					<div class="message-datetime">${message.createAt}</div>
					<div class="message-item-left">
						<img src="${appRoot}${message.publisherHead}" />
						<div class="message-link"></div>
						<p>${message.publisherName}</p>
					</div>
					<div class="message-item-right">
							${message.content}
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
</body>
</html>