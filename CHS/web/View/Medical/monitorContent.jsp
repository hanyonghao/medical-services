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
	<link rel="stylesheet" href="${appPublic}/Medical/css/monitorContent.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="report">
		<div class="report-head">
			<div class="report-title">${monitorType}监测</div>
			<div class="btn-back icon-reply" onclick="history.go(-1);"></div>
		</div>
		<div class="report-body">
			<div class="report-content">
				<table>
					<thead>
                        <tr>
                            <th class="report-value">监测值</th>
                            <th class="report-date">日期</th>
                        </tr>
					</thead>
					<tbody>
                        <c:forEach items="${monitors}" var="monitor">
                            <tr>
                                <td class="report-value">${monitor.values}</td>
                                <td class="report-date">${monitor.createAt}</td>
                            </tr>
                        </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
</body>
</html>