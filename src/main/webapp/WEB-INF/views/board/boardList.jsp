<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".go").click(function() {
			//location.href = "${board}List?curPage=" + $(this).attr("title") + "&kind=${listInfo.kind}&search=${listInfo.search}";
			document.frm.curPage.value = $(this).attr("title");
			document.frm.kind.value = '${listInfo.kind}';
			document.frm.search.value = '${listInfo.search}';
			document.frm.submit();
		});
	});
</script>
<style type="text/css">
	.go {
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1>${board}</h1>
	<div>
		<form action="${board}List" name="frm">
			<input type="hidden" name="curPage">
			<select name="kind">
				<option value="title">title</option>
				<option value="writer">writer</option>
				<option value="contents">contents</option>
			</select>
			<input type="text" name="search">
			<input type="submit" value="search">
		</form>
	</div>
	<table>
		<tr>
			<td>num</td>
			<td>title</td>
			<td>writer</td>
			<td>date</td>
			<td>hit</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<c:catch>
					<c:forEach begin="1" end="${dto.depth}">&nbsp;&nbsp;</c:forEach>				
				</c:catch>
				<td><a href="${board}View?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.hit}</td>
			</tr>	
		</c:forEach>
	</table>
	<c:if test="${listInfo.curBlock > 1}">
		<%-- <a href="${board}List?curPage=${listInfo.startNum - 1}&kind=${listInfo.kind}&search=${listInfo.search}">[이전]</a> --%>
		<span class="go" title="${listInfo.startNum - 1}">[이전]</span>	
	</c:if>
	<c:forEach begin="${listInfo.startNum}" end="${listInfo.lastNum}" var="i">
		<%-- <a href="${board}List?curPage=${i}&kind=${listInfo.kind}&search=${listInfo.search}">[${i}]</a> --%>
		<span class="go" title="${i}">[${i}]</span>
	</c:forEach>
	<c:if test="${listInfo.curBlock < listInfo.totalBlock}">
		<%-- <a href="${board}List?curPage=${listInfo.lastNum + 1}&kind=${listInfo.kind}&search=${listInfo.search}">[다음]</a> --%>
		<span class="go" title="${listInfo.lastNum + 1}">[다음]</span>
	</c:if>

	<a href="${board}Write">Write</a>
	<div>
		<p>curPage: ${listInfo.curPage}</p>
		<p>kind: ${listInfo.kind}</p>
		<p>search: ${listInfo.search}</p>
	</div>
</body>
</html>