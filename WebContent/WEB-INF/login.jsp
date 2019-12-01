<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/inc/header.jsp" %>
<script>
</script>
<body>
<form class="form" action="/myPosts/post" method="post">
ID:<input type="text" name="loginId" id="loginId">
パスワード:<input type="password" name="password" id="password">
<button class="waves-effect waves-light btn" type="submit">送信</button>
</form>
</body>
</html>