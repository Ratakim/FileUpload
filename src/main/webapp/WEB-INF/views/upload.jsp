<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Home</title>
</head>
<body>

	<!-- 파일 업로드에서는 enctype(인코딩타입)을 multipart/form-data로 반드시 설정 -->
	<body>
    <h3>파일 업로드</h3>
    <form id="fileUploadForm" method="post" action="/upload" enctype="multipart/form-data">
      파일 : <input type="file" id="uploadFile" name="uploadFile"><br><br>
      <input type="submit" value="업로드">
    </form>
  </body>

<a href="<c:url value='/download'/> ">다운로드 장소</a><br>
</body>
</html>
