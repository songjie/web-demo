<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>WebSocket示例</title>
<script src="/components/jquery/jquery.min.js"></script>
</head>
<body>
	<form action="msg/login" method="post">
		用户名:
		<select name="id">
			<option value="1">张三</option>
			<option value="2">李四</option>
		</select><br>
		密码:
		<input name="password" type="text" value="123456">
		<input type="submit" value="登录">
	</form>
</body>

</html>
