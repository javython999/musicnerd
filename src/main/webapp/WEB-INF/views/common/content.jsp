<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<section id="content">
      <ul id="articleItems" onclick={closeMenu()}>
      	<c:forEach var="list" items="${list }">
        <li class="articleItem" data-num="${list.article_id}">
          <div>
          	<div>
            	<iframe
            		width="100%"
            		height="auto"
            		src="https://www.youtube.com/embed/${list.video }?enablejsapi=1&controls=2&showinfo=0&modestbranding=1"
            		frameborder="0"
            		allowfullscreen
            	>
            	</iframe>
            </div>
            <div>${list.title}</div>
            <div>${list.content}</div>
            <div>${list.nickname}</div>
          </div>
        </li>
        </c:forEach>
      </ul>
</section>