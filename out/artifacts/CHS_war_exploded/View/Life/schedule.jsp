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
	<link rel="stylesheet" href="${appPublic}/Life/css/schedule.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="control">
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/guidance'">
			<p class="control-text">健康指导</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/dietary'">
			<p class="control-text">饮食推荐</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/movement'">
			<p class="control-text">运动建议</p>
		</div>
		<div class="control-item control-active" onclick="window.location.href = '${appRoot}/Life/schedule'">
			<p class="control-text">生活作息</p>
		</div>
	</div>
	<div class="schedule">
		<div class="schedule-datetime"></div>
		<div class="schedule-item">
			<div class="schedule-item-left">6:30<div class="schedule-middle" style="background: #ff5f3a;"></div></div>
			<div class="schedule-item-right">早晨 起床<div class="schedule-item-delete icon-remove"></div></div>
		</div>
		<div class="schedule-item">
			<div class="schedule-item-left">7:00<div class="schedule-middle" style="background: #ffce1b;"></div></div>
			<div class="schedule-item-right">早晨 晨运<div class="schedule-item-delete icon-remove"></div></div>
		</div>
		<div class="schedule-item">
			<div class="schedule-item-left">8:30<div class="schedule-middle" style="background: #b6ff34;"></div></div>
			<div class="schedule-item-right">早晨 吃早餐<div class="schedule-item-delete icon-remove"></div></div>
		</div>
		<div class="schedule-item">
			<div class="schedule-item-left">12:00<div class="schedule-middle" style="background: #47ff9e;"></div></div>
			<div class="schedule-item-right">中午 吃午饭<div class="schedule-item-delete icon-remove"></div></div>
		</div>
		<div class="schedule-item">
			<div class="schedule-item-left">18:00<div class="schedule-middle" style="background: #3c9aff;"></div></div>
			<div class="schedule-item-right">下午 吃晚饭<div class="schedule-item-delete icon-remove"></div></div>
		</div>
		<div class="schedule-item">
			<div class="schedule-item-left">20:00<div class="schedule-middle" style="background: #9848ff;"></div></div>
			<div class="schedule-item-right">晚上 吃药<div class="schedule-item-delete icon-remove"></div></div>
		</div>
		<div class="schedule-item">
			<div class="schedule-item-left">22:00<div class="schedule-middle" style="background: #ff76a4;"></div></div>
			<div class="schedule-item-right">晚上 吃夜宵<div class="schedule-item-delete icon-remove"></div></div>
		</div>
		<div class="schedule-item">
			<div class="schedule-item-left">23:30<div class="schedule-middle" style="background: #ffdb53;"></div></div>
			<div class="schedule-item-right">晚上 睡觉<div class="schedule-item-delete icon-remove"></div></div>
		</div>
		<div class="schedule-extend"></div>
		<button class="btn-add" type="button">添加</button>
	</div>
</div>
<div class="footer">
	<div class="menu">
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Index/index'">
			<p class="menu-ico icon-home"></p>
			<p class="menu-text">资讯</p>
		</div>
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Medical/index'">
			<p class="menu-ico icon-stethoscope"></p>
			<p class="menu-text">医疗</p>
		</div>
		<div class="menu-item text-active" onclick="window.location.href = '${appRoot}/Life/guidance'">
			<p class="menu-ico icon-dashboard"></p>
			<p class="menu-text">生活</p>
		</div>
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Mine/archives'">
			<p class="menu-ico icon-user"></p>
			<p class="menu-text">我</p>
		</div>
	</div>
</div>
<div class="confirm" style="display: none;">
	<div class="confirm-container">
		<div class="confirm-content">
			<div class="confirm-close icon-remove"></div>
			<div class="confirm-title">添加</div>
			<div class="confirm-form">
				<form action="" method="post">
					<input class="confirm-input schedule-time" type="time" name="time" autocomplete="off" placeholder="时间">
					<input class="confirm-input schedule-event" type="text" name="value" autocomplete="off" placeholder="事件">
					<button class="btn-submit" type="button">添加</button>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="btn-top icon-upload"></div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Base/js/base.js"></script>
<script src="${appPublic}/Life/js/schedule.js"></script>
</body>
</html>