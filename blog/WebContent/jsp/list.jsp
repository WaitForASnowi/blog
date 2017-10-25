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
<title>文章列表</title>
<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="<%=path%>/css/bootstrap.min.css"/>
<script type="text/javascript">
	function page(currentPage){
		$("#currentPage").val(currentPage);
		$("#pageForm").submit();
	}
	function deleteArticle(articleId){
		$("#darticleId").val(articleId);
		$("#deleteForm").submit();
	}
</script>
</head>
<body>
<div class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">申志强的博客</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">文章</a></li>
		</ul>
	</div>
</div>
<div style="margin-top:100px;margin-left:400px;margin-right:400px;">
	<c:if test="${sessionScope.identity eq 1 }">
		<div class="text-right" style="margin-bottom:20px">
		<a href="<%=path%>/jsp/new.jsp"><button class="btn btn-default">发表新文章</button></a>
		</div>
	</c:if>
	<table class="table table-hover text-center">
		<thead>
			<tr>
				<th class="text-center">标题</th>
				<th class="text-center">时间</th>
				<c:if test="${sessionScope.identity eq 1 }"><th class="text-center">操作</th></c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${result.data.list}" var="article">
				<tr>
					<td><a href="<%=path%>/article?articleId=${article.articleId}">${article.articleTitle }</a></td>
					<td>${article.publicationTime}</td>
					<c:if test="${sessionScope.identity eq 1 }"><td><button type="button" class="btn btn-default" onclick="deleteArticle(${article.articleId})">删除</button></td></c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul class="pager" style="margin-top:50px">
		<li onclick="page(${result.data.currentPage-1})"><a href="#">上一页</a></li>
		<li onclick="page(${result.data.currentPage+1})"><a href="#">下一页</a></li>
	</ul>
</div>
<form action="<%=path%>/articles" method="post" id="pageForm">
	<input type="hidden" id="currentPage" name="currentPage"/>
</form>
<form action="<%=path%>/article" method="post" id="deleteForm">
	<input type="hidden" name="_method" value="delete">
	<input type="hidden" id="darticleId" name="articleId">
	<input type="hidden" name="currentPage" value="${result.data.currentPage}">
</form>
</body>
</html>