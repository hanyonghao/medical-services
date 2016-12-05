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
	<link rel="stylesheet" href="${appPublic}/Index/css/index.css">
	<link rel="stylesheet" href="${appPublic}/Extend/Swiper/swiper-3.3.1.min.css">

</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="slide">
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide" onclick="window.location.href='#1'">
					<img src="${appPublic}/Index/img/brand_1.jpg"/>
				</div>
				<div class="swiper-slide" onclick="window.location.href='#2'">
					<img src="${appPublic}/Index/img/brand_2.jpg"/>
				</div>
				<div class="swiper-slide" onclick="window.location.href='#3'">
					<img src="${appPublic}/Index/img/brand_3.jpg"/>
				</div>
				<div class="swiper-slide" onclick="window.location.href='#4'">
					<img src="${appPublic}/Index/img/brand_4.jpg"/>
				</div>
			</div>
			<div class="swiper-pagination"></div>
			<div class="s-more" onclick="window.location.href=''">查看更多社区活动 <span class=" icon-angle-right"></span></div>
		</div>
	</div>
	<div class="news">
		<div class="n-title">
			健康资讯
			<div class="n-repeat">
				<span class="icon-repeat" title="刷新" onclick="window.location.reload(true);"></span>
			</div></div>
		<div class="n-item row-large" onclick="window.location.href='${appRoot}/Index/newsContent'">
			<div class="n-item-content n-multiple">
				<div class="n-item-title">一根有斑点的香蕉到底多厉害？</div>
				<div class="n-img">
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_one.png"></div>
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_two.png"></div>
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_three.png"></div>
				</div>
				<div class="n-item-msg">
					<span class="n-item-date">2分钟前</span>
					<span class="n-item-source">天天饮食</span>
					<div class="n-item-type">
						<span>涨知识</span>
					</div>
				</div>
				<div class="n-line"></div>
			</div>
		</div>
		<div class="n-item row-large" onclick="window.location.href='${appRoot}/Index/newsContent'">
			<div class="n-item-content n-multiple">
				<div class="n-item-title">一根有斑点的香蕉到底多厉害？</div>
				<div class="n-img">
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_one.png"></div>
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_two.png"></div>
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_three.png"></div>
				</div>
				<div class="n-item-msg">
					<span class="n-item-date">2分钟前</span>
					<span class="n-item-source">天天饮食</span>
					<div class="n-item-type">
						<span>涨知识</span>
					</div>
				</div>
				<div class="n-line"></div>
			</div>
		</div>
		<div class="n-item row-large" onclick="window.location.href='${appRoot}/Index/newsContent'">
			<div class="n-item-content n-multiple">
				<div class="n-item-title">一根有斑点的香蕉到底多厉害？</div>
				<div class="n-img">
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_one.png"></div>
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_two.png"></div>
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_three.png"></div>
				</div>
				<div class="n-item-msg">
					<span class="n-item-date">2分钟前</span>
					<span class="n-item-source">天天饮食</span>
					<div class="n-item-type">
						<span>涨知识</span>
					</div>
				</div>
				<div class="n-line"></div>
			</div>
		</div>
		<div class="n-item row-large" onclick="window.location.href='${appRoot}/Index/newsContent'">
			<div class="n-item-content n-multiple">
				<div class="n-item-title">一根有斑点的香蕉到底多厉害？</div>
				<div class="n-img">
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_one.png"></div>
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_two.png"></div>
					<div class="n-img-item"><img src="${appPublic}/Index/img/news_three.png"></div>
				</div>
				<div class="n-item-msg">
					<span class="n-item-date">2分钟前</span>
					<span class="n-item-source">天天饮食</span>
					<div class="n-item-type">
						<span>涨知识</span>
					</div>
				</div>
				<div class="n-line"></div>
			</div>
		</div>
		<div class="n-tips">加载中...</div>
	</div>
</div>
<div class="footer">
	<div class="menu">
		<div class="menu-item text-active" onclick="window.location.href = '${appRoot}/Index/index'">
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
		<div class="menu-item" onclick="window.location.href = '${appRoot}/Mine/archives'">
			<p class="menu-ico icon-user"></p>
			<p class="menu-text">我</p>
		</div>
	</div>
</div>
<div class="btn-top icon-upload"></div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Extend/Swiper/swiper-3.3.1.jquery.min.js"></script>
<script src="${appPublic}/Base/js/base.js"></script>
<script src="${appPublic}/Index/js/index.js"></script>
</body>
</html>