<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%-- セッションオブジェクトを削除する --%>
<%
  session.invalidate();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logout.jsp</title>

</head>
<body>
  <h2>
    ログアウトしました。<br>
  </h2>

  <br>
  <a href="./login.jsp">ログイン画面に戻る</a>
  <br>
</body>
</html>