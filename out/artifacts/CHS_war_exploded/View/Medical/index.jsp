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
	<link rel="stylesheet" href="${appPublic}/Medical/css/medical.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="control">
		<div class="control-item" onclick="window.location.href = '${appRoot}/Monitor/hospital'">
			<p class="control-ico icon-user-md"></p>
			<p class="control-text">预约</p>
		</div>
		<div class="control-item control-message" data-view="<c:out value='${viewCount}' default='0'/>" onclick="window.location.href = '${appRoot}/Message/index'">
			<p class="control-ico icon-envelope-alt"></p>
			<p class="control-text">消息</p>
            <img class="control-message-tips" src="${appPublic}/Base/img/red.png">
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Monitor/reportList'">
			<p class="control-ico icon-bar-chart"></p>
			<p class="control-text">病历</p>
		</div>
	</div>
	<div class="monitor">
        <c:forEach items="${monitors}" var="monitor">
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent?monitorType=${monitor.type}'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">${monitor.name}
                        <span class="monitor-item-tips">${monitor.values}</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
        </c:forEach>
        <c:if test="${empty monitors}">
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">血糖监测
                        <span class="monitor-item-tips">6 mmol/L</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">血压监测
                        <span class="monitor-item-tips">收缩压 109 mmHg; 舒张压 75 mmHg;</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">体温监测
                        <span class="monitor-item-tips">37.2 ℃</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">体重监测
                        <span class="monitor-item-tips">58 Kg; 脂肪 14.5%; 水分 60.2%; 肌肉 36.6%; 骨头 2.6%; 卡路里 892;</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">血氧监测
                        <span class="monitor-item-tips">40 mmHg</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">血脂监测
                        <span class="monitor-item-tips">160 mgdL</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">肝功能监测
                        <span class="monitor-item-tips">谷丙转氨酶 ALT 0~40; 谷草转氨酶 AST 0~40; 总胆红素 TBILI 5.1~19.0; 白蛋白 ALB 35~55</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">血尿常规监测
                        <span class="monitor-item-tips">PH 4.6~8.0</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">糖化血红蛋白监测
                        <span class="monitor-item-tips">6%~7%</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">骨骼肌质量指数监测
                        <span class="monitor-item-tips">SMM 2~3</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
            <div class="monitor-item" onclick="window.location.href = '${appRoot}/Medical/monitorContent'">
                <div class="monitor-item-content">
                    <div class="monitor-item-name">机体营养监测
                        <span class="monitor-item-tips">血蛋总白总 60~75 g/L</span>
                    </div>
                    <div class="monitor-item-ico icon-angle-right"></div>
                </div>
            </div>
        </c:if>
	</div>
</div>
<div class="footer">
	<div class="menu">
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Index/index'">
			<p class="menu-ico icon-home"></p>
			<p class="menu-text">资讯</p>
		</div>
		<div class="menu-item text-active" onclick="window.location.href = '${appRoot}/Medical/index'">
			<p class="menu-ico icon-stethoscope"></p>
			<p class="menu-text">医疗</p>
		</div>
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Life/guidance'">
			<p class="menu-ico icon-dashboard"></p>
			<p class="menu-text">生活</p>
		</div>
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Mine/archives'">
			<p class="menu-ico icon-user"></p>
			<p class="menu-text">我</p>
		</div>
	</div>
</div>
<div class="btn-top icon-upload"></div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Base/js/base.js"></script>
<script src="${appPublic}/Message/js/message.js"></script>
</body>
</html>