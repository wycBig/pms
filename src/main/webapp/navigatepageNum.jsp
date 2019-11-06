<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
    <title>附件管理</title>
    <link rel="stylesheet" type="text/css" href="skin/css/base.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
</head>
<div>
    <a href="${path}?pageNum=1${paramterMap}" >首页</a>
    <a href="${path}?pageNum=${mv.pageNum-1}${paramterMap}" >上一页</a>
    <c:forEach items="${mv.navigatepageNums}" var="pageNum" >
        <c:if test="${pageNum == mv.pageNum}">
            <span style="color: pink; font-weight: bold " >${pageNum}页</span>
        </c:if>
        <c:if test="${pageNum != mv.pageNum}">
            <a href="${path}?pageNum=${pageNum}">${pageNum}页</a>
        </c:if>
    </c:forEach>
    <a href="${path}?pageNum=${mv.pageNum+1}${paramterMap}" >下一页</a>
    <a href="${path}?pageNum=${mv.pages}${paramterMap}" >尾页</a>
    &nbsp;跳转到<input id="pageNum" size="1px" onblur="queryList()" />页
</div>
