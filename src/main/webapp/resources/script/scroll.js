'use strict';

// 무한스크롤 사용여부 판단
let isEnd = false;

// 스크롤의 위치 확인후 새로운 데이터 가져오기함수 fecthList()호출
$(function(){
   $(window).scroll(function(){
   let $window = $(this);
   let scrollTop = $window.scrollTop();
   let windowHeight = $window.height();
   let documentHeight = $(document).height();
            
   // scrollbar의 thumb가 바닥 전 1px까지 도달 하면 리스트를 가져온다.
   if( scrollTop + windowHeight + 1 > documentHeight ){
	  isEnd = false // 무한스크롤 작동으로 설정
      fetchList();  // 리스트 가져오는 함수 호출
   }})
})
    
// DB에서 새로운 데이터 가져와 VIEW페이지에 추가
function fetchList() {
	// 무한스크롤 작동이 맞는지 확인
	if(isEnd == true){
		// 무한스크롤 작동중지 일경우 아무것도 안하고 끝냄
        return;
    }

	// 무한스크롤 작동시
	// 현재 보여지는 리스트중 마지막 아이템의 id를 구하기
	let lastID = document.querySelectorAll(".articleItem");
	let testlength = lastID.length-1;
	let target = lastID[testlength];
	let num = parseInt(target.dataset.num);
		
    // 현재 페이지의 마지막 아이템의 이전 아이템의 아이디구하기
	let next = num-1
	
	// 마지막 아이템의 id-1이 0일경우 (더이상 불러올 아이템이 없을 경우)
	if(next <= 0) {
		// 아무것도 안하고 종료
		return;
	}
	
	// next부터 10개를 설정해 가져온다
	let end = next-10
	
	
    const startNum = "start="
	const endNUm = "end="
	$.ajax({
			async: true,
            type : 'GET',
            data : startNum + next + '&' + endNUm + end,
            url : "/article/list",
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
				// 무한스크롤 종료 설정
				isEnd = true;
			}
	 });
	}
        
 





       
    
