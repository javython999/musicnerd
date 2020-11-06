// 글 작성시 입력값 누락 확인
function checkWriteFormValue() {

  if (!document.querySelector(".articleTitle").value) {
    alert("제목을 입력하세요.");
    return false;
  }

  if (!document.querySelector(".articleContent").value) {
    alert("내용을 입력하세요.");
    return false;
  }

  if (!document.querySelector(".articleURL").value) {
    alert("유튜브영상URL을 입력하세요.");
    return false;
  }

}