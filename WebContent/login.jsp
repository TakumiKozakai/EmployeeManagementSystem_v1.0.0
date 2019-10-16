<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
</head>
<body>
  <h1>ログイン画面</h1>
  <hr>
  <br>

  <div style="color: red; font-weight: bold;">
    <%-- エラーメッセージがある場合は表示 --%>
    <c:out value="${requestScope.message }" />
  </div>

  <form action="./controller" method="POST">
    <!-- ボタンID用フィールド -->
    <input type="hidden" name="BUTTON_ID" value="UC000_01">
    <table>
      <tr>
        <td>ID:</td>
        <td><input type="text" name="ID"></td>
      </tr>
      <tr>
        <td>パスワード</td>
        <td><input type="text" name="PASSWORD"></td>
      </tr>
    </table>

    <br>
    <br> <input type="submit" value="送信">
  </form>

</body>
</html>