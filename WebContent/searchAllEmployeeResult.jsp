<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>searchAllEmployeeResult</title>
</head>
<body>
  <div style="text-align: center;">
    従業員一覧<br>
  </div>

  <table border="1" align="center">
    <tr>
      <td>ID</td>
      <td>NAME</td>
      <td>SECTION</td>
      <td>PHONE</td>
    </tr>

    <c:forEach items="${emp}" var="emp">
      <tr>
        <td><c:out value="${emp.id}" /></td>
        <td><c:out value="${emp.name }" /></td>
        <td><c:out value="${emp.section }" /></td>
        <td><c:out value="${emp.phone }" /></td>
      </tr>
    </c:forEach>
  </table>

  <div align="center">
    <a href="./Menu.html">メニュー</a>
  </div>
</body>
</html>