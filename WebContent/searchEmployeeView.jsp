<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>従業員検索</title>
  <script type="text/javascript">
    function initPage(){
      function inputCheck(e){
        var empid = document.getElementById("empid")
        if(empid.value == ""){
          e.preventDefault();
            alert("従業員IDを入力して下さい。");
            empid.focus();
        }
      }
      document.getElementById("inform").addEventListener("submit", inputCheck);
    }
    window.addEventListener("load", initPage);
  </script>
</head>
<body>
  <form action="./controller" method="POST" id="inform">
  <div style="text-align:center;">
    <p>検索する人のIDを入力して下さい。</p>
    <div style="color:red; font-weight:bold;">
      <%-- エラーメッセージがある場合は表示 --%>
      <c:out value="${requestScope.error }"/><br><br><br>
    </div>

    <input type="text" name="id" id="empid">
    <input type="submit" value="送信">

  </div>
  </form>
</body>
</html>