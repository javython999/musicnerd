<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<section id="noticeWrap">
	 	<div id="noticeWriteFormWrap">
	 	<c:if test="${sessionScope.user_id == 'admin' }">
	 		<form class="noticeWriteForm" method="post" action="notice/insert.do" onsubmit="return checkNoticeValue()">
	 			<input class="noticeTitle" type="text" name="title" placeholder="제목"/>
	 			<textarea class="noticeContent" name="content" placeholder="내용"></textarea>
	 			<section>
	 				<button class="Btn">작성</button>
	 				<button class="Btn" type="reset" onclick="noticeClose()">취소</button>
	 			</section>
	 		</form>
	 	</c:if>
	 	</div>
	<ul id="noticeItems"></ul>
</section>