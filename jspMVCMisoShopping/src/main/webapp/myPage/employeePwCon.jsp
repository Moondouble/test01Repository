
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myPwCon.jsp</title>
</head>
<body>
	<ul>
		<li><a href="<c:url value='/' />">홈</a></li>
		<li><a href="employeeMyPage.my">내정보 보기</a></li>
		<li><a href="employeeUpdate.my">내정보 수정</a></li>
		<li><a href="employeePwModify.my">비밀번호변경</a></li>
	</ul>
<form  action="employeePwUpdate.my" method="post">
비밀번호 확인 : <input type="password" name="employeePw" required="required"/>
			<div style="color:red">${errPw }</div>
			<input type="submit" value="확인"/>
</form>
</body>
</html>