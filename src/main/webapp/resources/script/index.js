'use strict'

// 로그인폼 open & close
const loginForm = document.querySelector('#loginForm');
let loginView = 'close';
function handleLoginOpen() {
	if(loginView === 'close') {
		$(loginForm).stop().slideDown();
		joinFormClose();
		loginView = 'open';
	}  else {
		$(loginForm).stop().slideUp();
		loginView = 'close';
	}
}


// 로그인 클릭시 로그인폼 등장
function handleClick() {
	const loginForm = document.querySelector('#loginForm');
	const loginBtn = document.querySelector('#loginBtn');
	const input_id = document.querySelector('#input_id');
	loginForm.style.display = 'block';
	loginBtn.style.opacity = 0;
	input_id.focus();
	
}

// 로그인 submit
function handleLoginSubmit() {
	const loginForm = document.querySelector('#loginForm');
	loginForm.submit();
}


// 로그인 취소
function handleLoginCancle() {
	const loginForm = document.querySelector('#loginForm');
	const loginBtn = document.querySelector('#loginBtn');
	loginForm.style.display = 'none';
	loginBtn.style.opacity = 1;
}


function LoginFormClose() {
	if(loginView == 'close') {
		return;
	} else {
		handleLoginOpen();
	}
}

// 회원가입폼 open & close
const joinForm = document.querySelector('#joinFormWrap');
let joinView = 'close';
function handleJoinOpen() {
	if(joinView === 'close') {
		$(joinForm).stop().slideDown();
		LoginFormClose();
		joinView = 'open';
	}  else {
		$(joinForm).stop().slideUp();
		joinView = 'close';
	}
}

function joinFormClose() {
	if(joinView == 'close') {
		return;
	} else {
		handleJoinOpen();
	}
}

// 아이디 중복체크
function id_duplex_check(input) {
	let form = input.form;
	
	form.id.value = form.id.value.trim();
	let checkId = form.id.value;
	const id = "id=";
	$.ajax({
			async: true,
            type : 'GET',
            data : id + checkId,
            url : "/member/join/idduplexcheck",
            dataType : "json",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
				if(data == '0') {
					$(".idCheckMsg").text("사용가능한 아이디입니다");
					$(".idChecker").val(0);
				} else {
					$(".idCheckMsg").text("이미 사용중인 아이디입니다");
					$(".idChecker").val(1);
				}
			}
	});
}



// 회원가입 닉네임 중복체크
function nick_duplex_check(input) {
	let form = input.form;
	
	form.nickname.value = form.nickname.value.trim();
	let checkNick = form.nickname.value;
	const nick = "nick=";
	$.ajax({
			async: true,
            type : 'GET',
            data : nick + checkNick,
            url : "/member/join/nickduplexcheck",
            dataType : "json",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
				if(data == '0') {
					$(".nickCheckMsg").text("사용가능한 닉네임입니다");
					$(".nickChecker").val(0);
				} else {
					$(".nickCheckMsg").text("이미 사용중인 닉네임입니다");
					$(".nickChecker").val(1);
				}
			}
	});
}

// 회원가입시 입력값 누락 확인
function checkValue() {

  if (!document.querySelector(".inputId").value) {
    alert("아이디를 입력하세요.");
    return false;
  }

  if (!document.querySelector(".inputPw").value) {
    alert("비밀번호를 입력하세요.");
    return false;
  }

  if (
    document.querySelector(".inputPw").value !=
    document.querySelector(".inputPwc").value
  ) {
    alert("비밀번호가 일치하지 않습니다.");
    return false;
  }

  if (!document.querySelector(".inputNic").value) {
    alert("닉네임을 입력하세요.");
    return false;
  }

  if (document.querySelector(".idChecker").value === '1') {
	alert("이미 사용중인 아이디입니다. 다른 아이디를 사용해주세요.");
    return false;
  }

  if (document.querySelector(".nickChecker").value === '1') {
	alert("이미 사용중인 닉네임입니다. 다른 닉네임을 사용해주세요.");
    return false;
  }
}





// 로그인 후 서비스 이용가능 alert
function loginAlert() {
	alert('로그인후 이용가능합니다.');
}

// up클릭시 위로 이동
const upBtn = document.querySelector(".fa-arrow-circle-up");
upBtn.addEventListener("click", () => {
  scrollTo({ top: 0, left: 0, behavior: "smooth" });
});



// 공지사항 open & close
const notice = document.querySelector('#noticeWrap');
let noticeView = 'close';
function handleNoticeOpen() {
	if(noticeView === 'close') {
		if(writeFormView === 'open') {
			handleWriteFormOpen();
		}
		$(notice).stop().slideDown();
		notice.style.opacity = 1;
		noticeView = 'open';
	} else {
		$(notice).stop().slideUp();
		notice.style.opacity = 0;
		noticeView = 'close';
		$('details').removeAttr("open");  
	}
}

// 글쓰기 open & close
const writeform = document.querySelector('#writeFormWrap');
let writeFormView = 'close';
function handleWriteFormOpen() {
	if(writeFormView === 'close') {
		if(noticeView === 'open') {
			handleNoticeOpen();
		}
		$(writeform).stop().slideDown();
		writeform.style.opacity = 1;
		writeFormView = 'open';
	} else {
		$(writeform).stop().slideUp();
		writeform.style.opacity = 0;
		writeFormView = 'close';
	}
}



function noticeClose() {
	// 콘텐츠 영역 클릭시 공지사항이 오픈되어있으면 닫기
	if(noticeView === 'close') {
		return;
	} else {
		handleNoticeOpen();
	}
}

function writeFormClose() {
	// 콘텐츠 영역 클릭시 공지사항이 오픈되어있으면 닫기
	if(writeFormView === 'close') {
		return;
	} else {
		handleWriteFormOpen();
	}
}

// 콘텐츠 영역 클릭시 모든 메뉴 닫아버리기
function closeMenu() {
	noticeClose();
	writeFormClose();
}


