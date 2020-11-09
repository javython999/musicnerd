<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="loginFormWrap">
	<form id="loginForm" method="post" action="member/login_check.do">
      	<input id="input_id" type="text" name="id" placeholder="아이디" />
      	<input type="hidden" id="idChecker"/>
      	<input id="input_pw" type="password" name="pw" placeholder="비밀번호"/>
      	<button class="loginBtn">로그인</button>
      	<button class="loginCancleBtn" type="reset" onclick="handleLoginOpen()">취소</button>
	</form>
</div>