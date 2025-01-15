<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>유저 목록</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>유저 목록</h1>
        </header>
        
        <section class="mb16">
            <table class="table">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>이름</th>
                        <th>직업</th>
                        <th>가입일자</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="member" items="${members}">
                        <tr>
                            <td>${member.id}</td>
                            <td>${member.name}</td>
                            <td>${member.job}</td>
                            <td>${member.createdAt}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </section>
        <button onClick="location.href='${pageContext.request.contextPath}/views/memberForm.jsp;'">회원 등록</button>
    </div>
</body>
</html>
