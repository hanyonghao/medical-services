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
	<link rel="stylesheet" href="${appPublic}/Mine/css/archives.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="user">
		<div class="u-head">
			<div class="u-img">
				<img src="${appRoot}${sessionScope.user.getHead()}">
			</div>
		</div>
		<div class="u-name">${sessionScope.user.getName()}</div>
        <input id="head-file" class="archives-file" type="file" name="headFile">
	</div>
	<div class="control">
		<div class="control-item control-active" onclick="window.location.href = '${appRoot}/Mine/archives'">
			<p class="control-text">健康档案</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Mine/history'">
			<p class="control-text">既往病史</p>
		</div>
	</div>
	<div class="archives">
		<div class="archives-form">
			<form id="archives-form" action="" method="post">
                <input name="id" type="hidden" value="${archives.id}">
                <input name="userId" type="hidden" value="${archives.userId}">
				<div class="archives-item">
					<label class="archives-label">性别 :</label>
					<div class="archives-group" style="padding-top: 15px;" data-value="${archives.sex}">
						<input id="sex-male" class="archives-radio" name="sex" type="radio" value="男"/> <label for="sex-male">男</label>
						<input id="sex-female" class="archives-radio" name="sex" type="radio" value="女"/> <label for="sex-female">女</label>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">血型 :</label>
					<div class="archives-group" style="padding: 10px 10px 10px 0;">
						<select class="archives-select" name="bloodType" data-value="${archives.bloodType}">
							<option value="A型">A型</option>
							<option value="B型">B型</option>
							<option value="AB型">AB型</option>
							<option value="O型">O型</option>
						</select>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">出生日期 :</label>
					<div class="archives-group">
						<input class="archives-input" type="date" name="birthday" autocomplete="off" placeholder="请在此输入..." value="${archives.birthday}"/>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">身份证 :</label>
					<div class="archives-group">
						<input class="archives-input" type="text" autocomplete="off" name="card" placeholder="请在此输入..." value="${archives.card}"/>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">身高 :</label>
					<div class="archives-group">
						<input class="archives-input" type="number" autocomplete="off" name="high" placeholder="请在此输入..." value="${archives.high}"/>
						<div class="archives-unit">cm</div>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">籍贯 :</label>
					<div class="archives-group">
						<input class="archives-input" type="text" autocomplete="off" name="origin" placeholder="请在此输入..." value="${archives.origin}"/>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">手机号 :</label>
					<div class="archives-group">
						<input class="archives-input" type="text" size="11" autocomplete="off" name="mobile" placeholder="请在此输入..." value="${archives.mobile}"/>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">省 :</label>
					<div class="archives-group" style="padding: 10px 10px 10px 0;">
						<select class="archives-select" name="province" data-value="${archives.province}">
							<option value="广东">广东</option>
						</select>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">市 :</label>
					<div class="archives-group" style="padding: 10px 10px 10px 0;">
						<select class="archives-select" name="city" data-value="${archives.city}">
							<option value="珠海">珠海</option>
						</select>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">区 :</label>
					<div class="archives-group" style="padding: 10px 10px 10px 0;">
						<select class="archives-select" name="area" data-value="${archives.area}">
							<option value="香洲区">香洲区</option>
                            <option value="高新区">高新区</option>
                            <option value="横琴区">横琴区</option>
                        </select>
					</div>
				</div>
				<div class="archives-item">
					<label class="archives-label">住址 :</label>
					<div class="archives-group">
						<input class="archives-input" type="text" name="quarters" autocomplete="off" placeholder="请在此输入..." value="${archives.quarters}"/>
					</div>
				</div>
				<div class="archives-item archives-submit">
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
<script type="text/javascript">
    var appRoot = "${appRoot}";
    var appPath = "${appPath}";
    var appPublic = "${appPublic}";
</script>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Base/js/base.js"></script>
<script src="${appPublic}/Base/js/ajaxfileupload.js"></script>
<jsp:include page="${appPublic}/Base/upload.html"></jsp:include>
<script src="${appPublic}/Mine/js/archives.js"></script>
</body>
</html>