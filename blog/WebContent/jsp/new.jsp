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
<title>发表新文章</title>
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"/>
</head>
<body>
<div style="margin-top:50px">
	<form  class="form-horizontal" action="<%=path%>/article" method="post">
		<input id="articleId" name="articleId" type="hidden" value="${articleId }">
		<div class="form-group">
			<label class="control-label col-sm-4">标题</label>
			<div class="col-sm-5"> 
				<input class="form-control" type="text" value="${articleTitle}" id="articleTitle" name="articleTitle"/>
			</div>
			
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">内容</label>
			<div class="col-sm-5">
				<textarea class="form-control" rows="40" id="articleContent" name="articleContent">${articleContent}</textarea>
			</div>
		</div>
		<div class="form-group text-center" style="margin-left:150px">
			<button class="btn btn-default" type="submit">发表</button>
		</div>
	</form>
</div>
<c:if test="${! empty result.message }">
		<script type="text/javascript">
			alert("${result.message}");
		</script>
</c:if>
<c:if test="${result.success eq true}">
	<script type="text/javascript">
		location.href="<%=path%>/articles";
	</script>
</c:if>
</html>