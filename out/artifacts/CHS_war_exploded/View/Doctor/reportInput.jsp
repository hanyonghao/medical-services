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
    <link rel="stylesheet" href="${appPublic}/Doctor/css/reportInput.css">
</head>
<body>
<div class="container">
    <div class="header">
        <div class="h-title">社区公共卫生服务 --- 医生端</div>
    </div>
    <div class="report">
        <div class="report-head">
            <div class="report-title">病历记录</div>
            <div class="btn-back icon-reply" onclick="history.go(-1);"></div>
        </div>
        <div class="report-body">
            <div class="report-content">
                <form action="${appRoot}\Doctor\updateReport" method="post">
                    <input type="hidden" name="recordId" value="${recordId}">
                    <div class="report-textarea">
                        <textarea class="report-textarea" name="content" title="此处填写患者病历..." placeholder="此处填写患者病历..."></textarea>
                    </div>
                    <div class="report-submit">
                        <button class="btn-submit" type="submit">保存</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
</body>
</html>