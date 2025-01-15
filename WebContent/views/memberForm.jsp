<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
  <div class="container">
    <h1>회원 등록</h1>
    <form action="${pageContext.request.contextPath}/members" method="post">
        <label>이름: </label>
        <input type="text" name="name" required><br>
        <label>성별: </label>
        <select name="sex">
            <option value="Male">남성</option>
            <option value="Female">여성</option>
        </select><br>
        <label>나이: </label>
        <input type="number" name="age" required><br>
        <label>직업: </label>
        <input type="text" name="job"><br>
        <label>취미: </label>
        <input type="text" name="hobby"><br>
        <button type="submit">등록</button>
    </form>
    </div>
</body>
</html>
