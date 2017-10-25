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
<title>详细</title>
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"/>
</head>
<body>
<div style="margin-top:50px">
	<form  class="form-horizontal" action="<%=path%>/article" method="post">
		<input id="articleId" name="articleId" type="hidden" value="${result.data.articleId }">
		<input name="_method" type="hidden" value="put">
		<div class="form-group">
			<label class="control-label col-sm-4">标题</label>
			<div class="col-sm-5"> 
				<input class="form-control" type="text" value="${result.data.articleTitle}" readonly="readonly" id="articleTitle" name="articleTitle"/>
			</div>
			
		</div>
		<div class="form-group">
			<label class="control-label col-sm-4">内容</label>
			<div class="col-sm-5">
				<textarea class="form-control" rows="40" readonly="readonly" id="articleContent" name="articleContent">${result.data.articleContent}</textarea>
			</div>
		</div>
		<div class="form-group text-center" style="margin-left:150px">
			<c:if test="${sessionScope.identity eq 1 }">
				<button class="btn btn-default" type="submit">修改</button>
			</c:if>
		</div>
	</form>
</div>
<c:if test="${! empty result.message }">
		<script type="text/javascript">
			alert("${result.message}");
		</script>
</c:if>
<c:if test="${result.success&&sessionScope.identity==1}">
		<script type="text/javascript">
			$("input").removeAttr("readonly");
			$("textarea").removeAttr("readonly");
		</script>
</c:if>
<c:if test="${empty result.data }">
	<script type="text/javascript">
		$("#articleId").val("${articleId}");
		$("#articleTitle").val("${articleTitle}");
		$("#articleContent").text("${articleContent}");
	</script>
</c:if>
</html>