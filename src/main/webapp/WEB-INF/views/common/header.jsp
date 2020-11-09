<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<header>
      <a href="/"><span class="logo">MusicNerd</span></a>
      <section id="headerMenu">
      	<c:if test="${sessionScope.user_nickname != null }">
      	<span>${sessionScope.user_nickname}님 반갑습니다.</span>
        <a id="loginBtn" href="member/logout.do"><span>로그아웃</span></a>
        </c:if>
        <c:if test="${sessionScope.user_nickname == null }">
        <a id="loginBtn"><span onclick="handleLoginOpen()">로그인</span></a>
        <a id="joinBtn" onclick="handleJoinOpen()"><span>회원가입</span></a>
        </c:if>
      </section>
</header>