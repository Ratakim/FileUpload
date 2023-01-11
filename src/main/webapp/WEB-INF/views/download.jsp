<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<title>Home</title>
</head>
<body>
    <a href="<c:url value='/'/> ">업로드 장소</a><br>
     <hr>
     
     <form action=/download.do method="post">
    <c:forEach items="${fileList}" var="fileL">
        ${fileL}<button type="submit" name="file" value="${fileL}">다운로드</button><br>
    </c:forEach>
       </form>

  </body>
</html>
