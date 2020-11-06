<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<nav>
      <a  onclick={playListRefresh()}><i class="fas fa-music"></i><span> PlayList</span></a>
      <c:if test="${sessionScope.user_nickname != null }">
      <a  onclick={handleWriteFormOpen()}><i class="far fa-edit"></i><span> 글쓰기</span></a>
      </c:if>
      <c:if test="${sessionScope.user_nickname == null }">
      <a  onclick={loginAlert()}><i class="far fa-edit"></i><span> 글쓰기</span></a>
      </c:if>
      <a onclick="handleNoticeOpen(); loadNotice();"><i class="fas fa-clipboard-check"></i><span> 공지사항</span></a>
</nav>