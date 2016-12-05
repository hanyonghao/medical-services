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
	<link rel="stylesheet" href="${appPublic}/Life/css/guidance.css">
</head>
<body>
<div class="container">
	<div class="header">
		<div class="h-title">社区公共卫生服务</div>
	</div>
	<div class="control">
		<div class="control-item control-active" onclick="window.location.href = '${appRoot}/Life/guidance'">
			<p class="control-text">健康指导</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/dietary'">
			<p class="control-text">饮食推荐</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/movement'">
			<p class="control-text">运动建议</p>
		</div>
		<div class="control-item" onclick="window.location.href = '${appRoot}/Life/schedule'">
			<p class="control-text">生活作息</p>
		</div>
	</div>
	<div class="guidance">
		<div class="guidance-item">
			<div class="guidance-left-color" style="background: #bae9ff;"></div>
			<div class="guidance-right-text">休息与活动：<br/>1.急性发作期有发热、喘息时应卧床休息，取舒适的坐位或半卧位，衣服要宽松，以减轻对呼吸运动的限制。<br/>2.缓解期可根据病情进行适当的锻炼，如步行、上下阶梯等，以运动后出现轻度呼吸短促，停止运动后10分钟可恢复至运动前水平为宜。</div>
		</div>
		<div class="guidance-item">
			<div class="guidance-left-color" style="background: #bfffd5;"></div>
			<div class="guidance-right-text">饮食：<br/>对心、肝、肾功能正常的病人，应保证每日饮水量1500ML以上。应摄入充足的蛋白质、维生素，食用易消化和不易发酵的食品，预防便秘和肠内积气。呼吸衰竭病人食物中应高蛋白、高脂肪和低碳水化合物的饮食。</div>
		</div>
		<div class="guidance-item">
			<div class="guidance-left-color" style="background: #f7ffb8;"></div>
			<div class="guidance-right-text">健康指导：<br/>加强个人卫生，避免各种诱发因素的接触和吸入。<br/>1.在上呼吸道疾病流行期间避免进出空气污染公共场所；<br/>2.减少冷空气的刺激，冬季晨起外出注意保暖或戴口罩。寒冷季节或气温骤降时注意保暖等；<br/>3.加强体育锻炼，提高机体耐寒及抗病能力，根据病情选择适合自己的活动，如散步、太极拳等。可在入冬前行耐寒锻炼，如用冷水洗脸、鼻，每天2-3次，每次2-3分钟；<br/>4.缓解期可进行呼吸运动锻炼，方法为：取立位（体弱者也可取坐位或仰卧位），一手防于腹部，一手防于胸前，吸气时用力挺腹，胸部不动，呼气时腹部内陷，尽量将气呼出，吸与呼之比为1：2或1：3。用鼻吸气，用口呼气，要求缓呼深吸，不可用力，每分钟速度保持在7-8次左右，可减少能量消耗。每日两次，每次10-20分钟；5.戒烟，避免烟、尘的摄入，尽早治疗呼吸道感染。家中配备常用药并掌握其使用方法；<br/>6.缓解期注意营养的摄入，改善全身营养状况，提高呼吸肌力量；<br/>7.保持心情愉快，注意自己调整心理，积极配合治疗护理。</div>
		</div>
		<div class="guidance-item">
			<div class="guidance-left-color" style="background: #ffc6dc;"></div>
			<div class="guidance-right-text">慢性支气管炎是指气管、支气管粘膜及其周围组织的慢性炎症。临床上以咳嗽、咳痰或伴有喘息反复发作为主要症状，冬季易发作，严重时可并发慢性阻塞性肺气肿甚至肺心病。以中老年人为多见，男性比女性多见。</div>
		</div>
		<div class="guidance-item">
			<div class="guidance-left-color" style="background: #eebfff;"></div>
			<div class="guidance-right-text">应注意选用易消化,富含蛋白质,高热量,富含维生素的食物,以保证营养的摄入,增加机体对感染的抵抗能力,忌辛辣刺激及油腻食品,萝卜,黄瓜,百合,银耳,芹菜,西瓜,橘子等蔬菜水果较为适宜。</div>
		</div>
		<div class="guidance-item">
			<div class="guidance-left-color" style="background: #b0bcff;"></div>
			<div class="guidance-right-text">由于老年患者体质较弱,睡眠,饮食,活动受到影响,患者容易产生消极,悲观或烦躁情绪,对治疗及康复不利.因此,应注意患者的情绪变化,向患者说明情绪波动对疾病的负性影响,鼓励患者保持乐观的心态,积极配合治疗.通过心理指导,可减轻患者的情绪变化对疾病的负性影响,促进机体康复。</div>
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
<div class="btn-top icon-upload"></div>
<script src="${appPublic}/Extend/JQuery/jquery-1.10.1.min.js"></script>
<script src="${appPublic}/Base/js/base.js"></script>
</body>
</html>