<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listing</title>
</head>
<body>
	<table>
		<tr>
			<th>StoryName</th>
			<th>Component</th>
			<th>Sprint</th>
			<th>Project</th>
		</tr>
		<c:forEach items="${stories}" var="story">
			<tr>
				<td>${story.storyName}</td>
				<td>${story.component}</td>
				<td>${story.sprint}</td>
				<td>${story.currentProject}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>