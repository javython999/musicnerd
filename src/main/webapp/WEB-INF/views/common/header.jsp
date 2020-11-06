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
        <a id="loginBtn"><span onclick={handleClick()}>로그인</span></a>
        <a href="#" onclick={handleJoin()}><span>회원가입</span></a>
        </c:if>
      </section>
      <form id="loginForm" method="post" action="member/login_check.do">
      	<input id="input_id" type="text" name="id" placeholder="아이디" />
      	<input type="hidden" id="idChecker"/>
      	<input id="input_pw" type="password" name="pw" placeholder="비밀번호"/>
      	<button>로그인</button>
      	<button type="reset" onclick={handleLoginCancle()}>취소</button>
   	  </form>
</header>