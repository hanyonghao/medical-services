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
	<link rel="stylesheet" href="${appPublic}/Doctor/css/reportContent.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务 --- 医生端</div>
	</div>
	<div class="report">
		<div class="report-head">
			<div class="report-title">病历记录</div>
			<div class="btn-back icon-reply" onclick="window.location.href='${appRoot}/Doctor/reportList'"></div>
		</div>
		<div class="report-body">
			<div class="report-content">
				<div class="report-info">
					<div class="report-info-item">医院：${record.hospitalName}</div>
					<div class="report-info-item">医生：${record.doctorName}</div>
					<div class="report-info-item">时间：${record.orderDate}</div>
					<div class="report-info-item">科目：${record.doctorSubjectType}</div>
				</div>
				<div class="report-text" style="word-wrap:break-word;word-break:break-all;">
                    ${record.content}
				</div>
			</div>
		</div>
	</div>
</div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
</body>
</html>