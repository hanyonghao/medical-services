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
	<link rel="stylesheet" href="${appPublic}/Backstage/css/archives.css">

</head>
<body>
<div class="wrapper">
	<div class="main">
        <div class="side">
            <div class="m-datetime">
                <div class="m-time"></div>
                <div class="m-date"></div>
            </div>
            <div class="side-item side-active" onclick="window.location.href='${appRoot}/Backstage/user'">
                <span class="side-ico icon-user"></span>
                <span class="side-text">用户管理</span>
            </div>
            <div class="side-item" onclick="window.location.href='${appRoot}/Backstage/doctor'">
                <span class="side-ico icon-user-md"></span>
                <span class="side-text">医生管理</span>
            </div>
            <div class="side-item" onclick="window.location.href='${appRoot}/Backstage/interfaces'">
                <span class="side-ico icon-magnet"></span>
                <span class="side-text">接口管理</span>
            </div>
            <%--<div class="side-item" onclick="window.location.href='${appRoot}/Backstage/report'">--%>
                <%--<span class="side-ico icon-bar-chart"></span>--%>
                <%--<span class="side-text">数据分析</span>--%>
            <%--</div>--%>
        </div>
		<div class="content">
			<div class="title"><a href="${appRoot}/Backstage/user">用户管理</a> > 健康档案 > ${userName}</div>
			<div class="table">
				<div class="table-item">
					<div class="table-label">性别：</div>
					<div class="table-text">${archive.sex}</div>
				</div>
				<div class="table-item">
					<div class="table-label">身份证：</div>
					<div class="table-text">${archive.card}</div>
				</div>
				<div class="table-item">
					<div class="table-label">血型：</div>
					<div class="table-text">${archive.bloodType}</div>
				</div>
				<div class="table-item">
					<div class="table-label">生日：</div>
					<div class="table-text">${archive.birthday}</div>
				</div>
				<div class="table-item">
					<div class="table-label">身高：</div>
					<div class="table-text">${archive.high}</div>
				</div>
				<div class="table-item">
					<div class="table-label">籍贯：</div>
					<div class="table-text">${archive.origin}</div>
				</div>
				<div class="table-item">
					<div class="table-label">手机号：</div>
					<div class="table-text">${archive.mobile}</div>
				</div>
				<div class="table-item">
					<div class="table-label">省：</div>
					<div class="table-text">${archive.province}</div>
				</div>
				<div class="table-item">
					<div class="table-label">市：</div>
					<div class="table-text">${archive.city}</div>
				</div>
				<div class="table-item">
					<div class="table-label">区：</div>
					<div class="table-text">${archive.area}</div>
				</div>
				<div class="table-item">
					<div class="table-label">住址：</div>
					<div class="table-text">${archive.quarters}</div>
				</div>
			</div>
		</div>
		<div class="exit icon-remove-sign" title="退出系统" onclick="window.location.href='${appRoot}/Backstage/exit'"></div>
	</div>
</div>
<script type="text/javascript">
	var appRoot = "${appRoot}";
	var appPath = "${appPath}";
	var appPublic = "${appPublic}";
</script>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Backstage/js/archives.js"></script>
</body>
</html>