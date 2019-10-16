<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addEmployee.jsp</title>
</head>
<body>
  <div style="text-align: center;">
    <form action="./controller" method="post">
      <input type="hidden" name="BUTTON_ID" value="UC002_03_01">

      <table border="0" align="center">
        <tr>
          <td align="right">ID<input type="text" name="ID"></td>
        </tr>
        <tr>
          <td align="right">NAME<input type="text" name="NAME"></td>
        </tr>
        <tr>
          <td align="right">SECTION<input type="text" name="SECTION"></td>
        </tr>
        <tr>
          <td align="right">PHONE<input type="text" name="PHONE"></td>
        </tr>
        <tr>
          <td align="right">PASSWORD<input type="text" name="PASSWORD"></td>
        </tr>
      </table>

      <input type="submit" value="登録"> <input type="submit"
        value="キャンセル">
    </form>

  </div>
</body>
</html>