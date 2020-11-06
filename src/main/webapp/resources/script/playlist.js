'use strict';
function playListRefresh() {
	closeMenu();
	$('#articleItems').empty();
	const articleItems = document.querySelector('#articleItems');
	articleItems.style.height = '100vh';
	$.ajax({
			async: true,
            type : 'GET',
            url : "/refresh",
            dataType : "json",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
				$(data).each(function(){
				 let str = "<li class='articleItem' data-num='"+this.article_id+"'>"
					+"<div>"
					+"<div>"
					+"<iframe width='100%' height='auto' src='https://www.youtube.com/embed/"+this.video+"?enablejsapi=1&controls=2&showinfo=0&modestbranding=1"+"' frameborder='0' allowfullscreen controls='2'>"
					+"</iframe>"
					+"</div>"
					+"<div>"+this.title+"</div>"
					+"<div>"+this.content+"</div>"
					+"<div>"+this.nickname+"</div>"
					+"</div>"
					+"</li>"
					
					// view페이지에 불러온 데이터 추가
					$("#articleItems").append(str);
				});
				articleItems.style.height = '100%';
				}}
				)}

