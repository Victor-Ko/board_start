<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="locale" value="${pageContext.response.locale}" scope="session" />
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1">

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="resourcePath" value="${contextPath}/resources"/>

<script>
var contextPath = "${contextPath}";
var resourcePath = "${resourcePath}";
</script>

<%
SimpleDateFormat formatedDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
String nowDate = formatedDate.format(new java.util.Date());
%>

<script src="${resourcePath}/jquery/jquery-2.1.3.min.js" charset="utf-8"></script>
<script src="${resourcePath}/jquery/jquery-ui.min.js" charset="utf-8"></script>
<script src="${resourcePath}/jquery/jquery.csv.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="${resourcePath}/jquery/jquery-ui.min.css">