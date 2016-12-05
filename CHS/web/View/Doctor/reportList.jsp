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
    <link rel="stylesheet" href="${appPublic}/Doctor/css/reportList.css">
</head>
<body>
<div class="container">
    <div class="header">
        <div class="h-title">社区公共卫生服务 --- 医生端</div>
    </div>
    <div class="report">
        <c:forEach items="${records}" var="record">
            <div class="report-item" data-id="${record.id}">
                <div class="report-item-left">
                    <img src="${appRoot}${record.userHead}" />
                </div>
                <div class="report-item-right">
                    <div class="report-user">
                        <span class="report-name">${record.userName}</span>
                        <span class="report-sex">${record.userSex}</span>
                        <span class="report-sex">${record.userAge}岁</span>
                        <c:if test="${record.isWrite == 0}">
                            <span class="report-status" style="color: #777777;">待填写</span>
                        </c:if>
                        <c:if test="${record.isWrite == 1}">
                            <span class="report-status" style="color: #c5c218;">已填写</span>
                        </c:if>
                    </div>
                    <div class="report-date">就诊时间：${record.orderDate}</div>
                    <div class="report-remark">概况描述：${record.remark}</div>
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
        <div class="menu-item" onclick="window.location.href = '${appRoot}/Doctor/order'">
            <p class="menu-ico icon-time"></p>
            <p class="menu-text">预约</p>
        </div>
        <div class="menu-item text-active" onclick="window.location.href = '${appRoot}/Doctor/reportList'">
            <p class="menu-ico icon-bar-chart"></p>
            <p class="menu-text">病历</p>
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
<script src="${appPublic}/Doctor/js/reportList.js"></script>
</body>
</html>