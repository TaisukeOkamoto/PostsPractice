<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="bean.User" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Arrays" %>
<%@include file="/WEB-INF/inc/header.jsp" %>
<script>

//初期化
$(function() {
	ajax("get","/myPosts/getUserList")
	.then(function(userList) {
		var html = "";
		for(i = 0; i < userList.length; i++) {
			html += "<tr>";
			html += "<td>" + userList[i].id + "</td>";
			html += "<td>" + userList[i].mail + "</td>";
			html += "<td>" + userList[i].name + "</td>";
			html += "<td><a onClick='deleteUser("+ userList[i].id  + ")'>" + "削除" + "</a></td>";
			html += "</tr>";
		}
		$("#table_body").html(html);
	});
})

//削除
function deleteUser(id) {

	var request = {
			"id":id
	}

	ajax("post","/myPosts/delete",request)
	.then(function(userList) {
		var html = "";
		for(i = 0; i < userList.length; i++) {
			html += "<tr>";
			html += "<td>" + userList[i].id + "</td>";
			html += "<td>" + userList[i].mail + "</td>";
			html += "<td>" + userList[i].name + "</td>";
			html += "<td><a onClick='deleteUser("+ userList[i].id  + ")'>" + "削除" + "</a></td>";
			html += "</tr>";
		}
		$("#table_body").html(html);
	})
}
</script>

</head>
<body>

<h1 style="font-size:20px;">掲示板へようこそ</h1>
 <div>

 </div>
 メンバー一覧
      <table class="striped">
        <thead>
          <tr>
              <th>id</th>
              <th>名前</th>
              <th>メールアドレス</th>
              <th>削除</th>
          </tr>
        </thead>
        <tbody id="table_body">
        </tbody>
      </table>
</body>
</html>