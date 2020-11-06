<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<section id="writeFormWrap">
	<form id="writeForm" action="article/insert.do" method="post" onsubmit="return checkWriteFormValue()">
		<input type="hidden" name="id" value="${sessionScope.user_id}" />
		<input type="hidden" name="nickname" value="${sessionScope.user_nickname}" />
		<input class="articleTitle" type="text" name="title" placeholder="제목"/>
		<input class="articleContent" type="text" name="content" placeholder="내용"/>
		<input class="articleURL" type="text" name="video" placeholder="Youtube영상 주소"/>
		<div>
			<button class="Btn">작성</button>
      		<button class="Btn" type="reset" onclick={handleWriteFormOpen()}>취소</button>
		</div>
	</form>
</section>