<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	String path=request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"/>
</head>
<body>
	<div class="text-center" style="margin-top:15%">
		<h2 class="text-center">登录</h2>
		<form class="form-horizontal" action="<%=path%>/login" method="post" style="margin-top:20px">
			<div class="form-group">
				<label class="col-sm-5 control-label">用户名</label>
				<div class="col-sm-2">
					<input class="form-control" type="text" name="username" value="${requestScope.username }"/>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-5 control-label">密码</label>
				<div class="col-sm-2">
					<input class="form-control" type="password" name="password" value="${requestScope.password }"/> 
				</div>
			</div>
			<div class="form-group">
				<div class="text-center">
					<button class="btn btn-primary" type="submit">登录</button>
					<a href="<%=path%>/register.jsp">
					<button class="btn btn-primary" type="button">注册</button>
					</a>
				</div>
			</div>
		</form>
	</div>
	<c:if test="${! empty result.message }">
		<script type="text/javascript">
			alert("${result.message}");
		</script>
	</c:if>
</body>
</html>