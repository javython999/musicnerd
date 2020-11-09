<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap" rel="stylesheet">
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
  <script src="https://kit.fontawesome.com/f87cacf99d.js" crossorigin="anonymous"></script>
  <script type="text/javascript" src="/resources/script/jquery-3.5.1.min.js" defer=""></script>
  <script type="text/javascript" src="/resources/script/index.js" defer />"></script>
  <script type="text/javascript" src="/resources/script/playlist.js" defer />"></script>
  <script type="text/javascript" src="/resources/script/notice.js" defer />"></script>
  <script type="text/javascript" src="/resources/script/scroll.js" defer />"></script>
  <script type="text/javascript" src="/resources/script/writeForm.js" defer />"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js" defer></script>

  
  <title>MusicNerd</title>
</head>
<body>
  <div id='wrap'>
    <%@include file="/WEB-INF/views/common/header.jsp" %>
    <%@include file="/WEB-INF/views/common/login.jsp" %>
    <%@include file="/WEB-INF/views/common/joinform.jsp" %>
    <%@include file="/WEB-INF/views/common/nav.jsp" %>
    <%@include file="/WEB-INF/views/common/writeform.jsp" %>
    <%@include file="/WEB-INF/views/common/notice.jsp" %>
    <%@include file="/WEB-INF/views/common/content.jsp" %>
    
    <i class="fas fa-arrow-circle-up"></i>
  </div>
</body>
</html>