'use strict';

let noticeDetails = '';

function loadNotice() {	
	const noticeItems = document.querySelector('#noticeItems');
	$(noticeItems).empty();
	$.ajax({
			async: true,
            type : 'GET',
            url : "/notice",
            dataType : "json",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
				$(data).each(function(){
				 let regdate = moment(this.regdate).format('YYYY-MM-DD');
				 let str = "";
					 str += "<li class='noticeItem' data-noticeId="+this.notice_id+">"
					 str += "<div>"
					 str += "<details onclick='noticeAutoClose()'>"
					 str += "<summary>"+this.title+"</summary>"
				     str += "<article onclick='handleDetailClose(this)'>"
					 str += "<div>"+regdate+"</div>"
					 str += "<div>"+this.content+"</div>"
					 str += "</details>"
				     str += "</article>"
					 str += "</div>"
					 str += "</li>"
					
					// view페이지에 불러온 데이터 추가
					$(noticeItems).append(str);
				});
				noticeDetails = document.querySelectorAll('details');
			}
		}	
	)
}

// 클릭한 공지사항 외 다른 공지사항 닫기
function noticeAutoClose() {
	$(noticeDetails).click(function (event) {
    $(noticeDetails).not(this).removeAttr("open");  
});
}

function handleDetailClose(target) {
	
	const targetDetail = $(target).prev();
	targetDetail.trigger("click");
	console.log(targetDetail);
	console.log('!');
}



// 공지사항 작성시 입력값 누락 확인
function checkNoticeValue() {

  if (!document.querySelector(".noticeTitle").value) {
    alert("제목을 입력하세요.");
    return false;
  }

  if (!document.querySelector(".noticeContent").value) {
    alert("내용을 입력하세요.");
    return false;
  }

}

