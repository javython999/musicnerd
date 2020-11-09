<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="joinFormWrap">
  <form action="member/insert.do" method="post" onsubmit="return checkValue()">
  	<div class="idCheckMsg">아이디 설정</div>
  	<input class="idChecker" type="hidden" />
  	<input class="inputId" type="text" name="id" placeholder="아이디" onkeyup="id_duplex_check(this)"/>
  	<div class="pwCheckMsg">비밀번호 설정</div>
  	<input class="inputPw" type="password" name="pw" placeholder="비밀번호"/>
  	<input class="inputPwc" type="password" name="pwCheck" placeholder="비밀번호 확인"/>
  	<div class="nickCheckMsg">닉네임 설정</div>
  	<input class="nickChecker" type="hidden" />
  	<input class="inputNic" type="text" name="nickname" placeholder="닉네임" onkeyup="nick_duplex_check(this)" />
  	<div class="joinBtnBox">
  		<input class="joinSubmitBtn" type="submit" value="가입"/>
  		<button class="joinCancleBtn" type="reset" onclick="handleJoinOpen()">취소</button>
  	</div>
  </form>
</div>