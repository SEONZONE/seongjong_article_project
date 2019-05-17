<!doctype html>
<!-- 
p.277 [리스트 11.9] 회원가입 화면
 -->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글쓰기</title>
</head>
<body>
	<h2>글쓰기</h2>
	<table>
	<tr>
		<td>
		Writer<input type ="text" name="writer" value="${article.name }" readonly="readonly">
	</td>
	<td>
	   updatetime<input type = "text" name="cdate" value="${article.cdate}" readonly="readonly">
	   </td>
	   </tr>
	   </table>
	<p>
			Title:<br> <input type="text" name="title" value="${article.title }" readonly="readonly">
	</p>
	<p>
			<p>${article.contentHtml }</p>
		</p>
		
		<button type="submit"  onclick="location.href='/project/app/articlelist.jsp' ">return to list</button>
		
		
</body>
</html>