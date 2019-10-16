<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>found.jsp</title>
</head>
<body>
  <div style="text-align:center;">
  該当者が見つかりました。<br>

  <%-- 検索結果の表示 --%>
  ID		:<c:out value="${requestScope.emp.id }"/><br>
  NAME		:<c:out value="${requestScope.emp.name }"/><br>
  SECTION	:<c:out value="${requestScope.emp.section }"/><br>
  PHONE		:<c:out value="${requestScope.emp.phone }"/><br>
  </div>

</body>
</html>