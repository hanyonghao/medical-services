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
	<link rel="stylesheet" href="${appPublic}/Mine/css/history.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="user">
		<div class="u-head">
			<div class="u-img">
				<img src="${appRoot}${user.getHead()}">
			</div>
		</div>
		<div class="u-name">${user.getName()}</div>
		<input id="head-file" class="history-file" type="file" name="headFile">
	</div>
	<div class="control">
		<div class="control-item" onclick="window.location.href = '${appRoot}/Mine/archives'">
			<p class="control-text">健康档案</p>
		</div>
		<div class="control-item control-active" onclick="window.location.href = '${appRoot}/Mine/history'">
			<p class="control-text">既往病史</p>
		</div>
	</div>
	<div class="history">
		<div class="history-form">
			<form action="" method="post">
				<div class="history-item">
					<div class="history-ico icon-chevron-right"></div>
					<div class="history-title">当前疾病</div>
					<table class="history-option">
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">高压病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">糖尿病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">冠心病
							</td>
						</tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">慢性支气管
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">老年痴呆症
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">贫血
							</td>
						</tr>
					</table>
				</div>
				<div class="history-item">
					<div class="history-ico icon-chevron-right"></div>
					<div class="history-title">既往病史</div>
					<table class="history-option">
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">高压病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">糖尿病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">冠心病
							</td>
						</tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">慢性支气管
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">老年痴呆症
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">贫血
							</td>
						</tr>
					</table>
				</div>
				<div class="history-item">
					<div class="history-ico icon-chevron-right"></div>
					<div class="history-title">家庭病史</div>
					<table class="history-option">
						<tr><td class="history-option-title" colspan="3">父亲</td></tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">高压病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">糖尿病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">冠心病
							</td>
						</tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">慢性支气管
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">老年痴呆症
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">贫血
							</td>
						</tr>
						<tr><td class="history-option-title" colspan="3">母亲</td></tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">高压病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">糖尿病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">冠心病
							</td>
						</tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">慢性支气管
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">老年痴呆症
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">贫血
							</td>
						</tr>
						<tr><td class="history-option-title" colspan="3">同辈</td></tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">高压病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">糖尿病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">冠心病
							</td>
						</tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">慢性支气管
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">老年痴呆症
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">贫血
							</td>
						</tr>
						<tr><td class="history-option-title" colspan="3">孩子</td></tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">高压病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">糖尿病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">冠心病
							</td>
						</tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">慢性支气管
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">老年痴呆症
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">贫血
							</td>
						</tr>
					</table>
				</div>
				<div class="history-item">
					<div class="history-ico icon-chevron-right"></div>
					<div class="history-title">遗传病史</div>
					<table class="history-option">
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">高压病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">糖尿病
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">冠心病
							</td>
						</tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">慢性支气管
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">老年痴呆症
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">贫血
							</td>
						</tr>
					</table>
				</div>
				<div class="history-item">
					<div class="history-ico icon-chevron-right"></div>
					<div class="history-title">过敏物质</div>
					<table class="history-option">
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">青霉素
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">阿莫西林
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">氨基比林
							</td>
						</tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">索密痛
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">磺胺嘧啶
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">长效磺胺
							</td>
						</tr>
						<tr>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">鲁米那
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">阿司匹林
							</td>
							<td class="history-option-item">
								<input type="checkbox" name="historyOption" value="">丙种球蛋白
							</td>
						</tr>
					</table>
				</div>
				<div class="history-item history-submit">
					<button class="btn-submit" type="button">保存</button>
				</div>
			</form>
		</div>
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
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Life/guidance'">
			<p class="menu-ico icon-dashboard"></p>
			<p class="menu-text">生活</p>
		</div>
		<div class="menu-item text-active" onclick="window.location.href = '${appRoot}/Mine/archives'">
			<p class="menu-ico icon-user"></p>
			<p class="menu-text">我</p>
		</div>
	</div>
</div>
<div class="btn-top icon-upload"></div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Base/js/base.js"></script>
<script src="${appPublic}/Base/js/ajaxfileupload.js"></script>
<jsp:include page="${appPublic}/Base/upload.html"></jsp:include>
<script src="${appPublic}/Mine/js/history.js"></script>
</body>
</html>