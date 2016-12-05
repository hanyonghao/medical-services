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
	<link rel="stylesheet" href="${appPublic}/Backstage/css/interfaces.css">

</head>
<body>
<div class="wrapper">
	<div class="main">
        <div class="side">
            <div class="m-datetime">
                <div class="m-time"></div>
                <div class="m-date"></div>
            </div>
            <div class="side-item" onclick="window.location.href='${appRoot}/Backstage/user'">
                <span class="side-ico icon-user"></span>
                <span class="side-text">用户管理</span>
            </div>
            <div class="side-item" onclick="window.location.href='${appRoot}/Backstage/doctor'">
                <span class="side-ico icon-user-md"></span>
                <span class="side-text">医生管理</span>
            </div>
            <div class="side-item side-active" onclick="window.location.href='${appRoot}/Backstage/interfaces'">
                <span class="side-ico icon-magnet"></span>
                <span class="side-text">接口管理</span>
            </div>
            <%--<div class="side-item" onclick="window.location.href='${appRoot}/Backstage/report'">--%>
                <%--<span class="side-ico icon-bar-chart"></span>--%>
                <%--<span class="side-text">数据分析</span>--%>
            <%--</div>--%>
        </div>
		<div class="content">
			<div class="title"><a href="${appRoot}/Backstage/interfaces">接口管理</a></div>
			<div class="table">
				<div class="table-group">
					<div class="table-title">健康监测录入接口</div>
                    <div class="table-info">
                        <span>接口URL：${appRoot}/Backstage/addMonitor</span>
                        <span>参数：用户ID userId , 监测值 monitorValues, 监测类型 monitorType </span>
                        <span>返回类型：JSON</span>
                    </div>
					<div class="table-form">
						<form action="${appRoot}/Backstage/addMonitor" method="get" target="_blank">
                            <div class="table-item table-select">
                                <label>用户：</label>
                                <select name="userId">
                                    <c:forEach items="${users}" var="user">
                                        <option value="${user.id}">${user.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
							<div class="table-item table-input">
								<label>监测值：</label>
								<input type="text" name="monitorValues">
							</div>
							<div class="table-item table-select">
								<label>监测类型：</label>
								<select name="monitorType">
                                    <c:forEach items="${monitorType}" var="type">
                                        <option value="${type}">${type}</option>
                                    </c:forEach>
								</select>
							</div>
                            <button class="btn-submit" type="submit">提交</button>
						</form>
					</div>
				</div>
                <div class="table-group">
                    <div class="table-title">健康监测获取接口</div>
                    <div class="table-info">
                        <span>接口URL：${appRoot}/Backstage/getMonitor</span>
                        <span>参数：用户ID userId , 监测类型 monitorType </span>
                        <span>返回类型：JSON</span>
                    </div>
                    <div class="table-form">
                        <form action="${appRoot}/Backstage/getMonitor" method="get" target="_blank">
                            <div class="table-item table-select">
                                <label>用户：</label>
                                <select name="userId">
                                    <c:forEach items="${users}" var="user">
                                        <option value="${user.id}">${user.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="table-item table-select">
                                <label>监测类型：</label>
                                <select name="monitorType">
                                    <option value="all">全部</option>
                                    <c:forEach items="${monitorType}" var="type">
                                        <option value="${type}">${type}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button class="btn-submit" type="submit">提交</button>
                        </form>
                    </div>
                </div>
                <div class="table-group">
                    <div class="table-title">健康档案获取接口</div>
                    <div class="table-info">
                        <span>接口URL：${appRoot}/Backstage/getArchives</span>
                        <span>参数：用户ID userId </span>
                        <span>返回类型：JSON</span>
                    </div>
                    <div class="table-form">
                        <form action="${appRoot}/Backstage/getArchives" method="get" target="_blank">
                            <div class="table-item table-select">
                                <label>用户：</label>
                                <select name="userId">
                                    <c:forEach items="${users}" var="user">
                                        <option value="${user.id}">${user.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <button class="btn-submit" type="submit">提交</button>
                        </form>
                    </div>
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
<script src="${appPublic}/Backstage/js/interfaces.js"></script>
</body>
</html>