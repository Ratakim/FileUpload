<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	

<html>
<head>
<title>Home</title>
</head>
<body>
<!-- fileUploadResult.jsp -->
    <body>
        ${originalFileName} 파일을 업로드 하였습니다.<br>
    </body>
    
    <a href="<c:url value='/download'/> ">다운로드 장소</a><br>
</body>
</html>
