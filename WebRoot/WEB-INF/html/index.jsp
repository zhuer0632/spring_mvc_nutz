<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<#assign path="${request.getContextPath()}">
<html>
	<head>
		<title>首页</title>
		<style type="text/css">
.divclass {
	margin: 10px;
	border: 1px solid red;
}

.divclass input {
	display: block;
	margin: 20px;
}
</style>
		<script type="text/javascript" src="${path}/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="${path}/js/common.js"></script>
		<script type="text/javascript">
	$(document).ready(function() {
		$("#btn0").click(func0);
		$("#btn1").click(func1);
		$("#btn2").click(func2);
	});

	function func0() {
		var result = getJson("", "${path}/testTrans/test00.do");
		alert(result);
	}

	function func1() {
		var result = getJson("", "${path}/testTrans/test01.do");
		alert(result);
	}

	function func2() {
		var result = getJson("", "${path}/testTrans/test02.do");
		alert(result);
	}
</script>
	</head>
	<body>
		t${path}
		<br>
		${user.userName}
		<br>
		<div>
			<form action="${path}/person/addperson.do">
				<input type="submit" value="添加" />
			</form>
		</div>

		<div class="divclass">
			<input type="button" id="btn0" value="测试0">
			<input type="button" id="btn1" value="测试1-一个事务中访问了表，是否还能读取metadata">
			<input type="button" id="btn2" value="测试2">
			<input type="button" id="btn3" value="测试3">
		</div>

	</body>
</html>
