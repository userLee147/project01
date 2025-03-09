<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      * {
        box-sizing: border-box;
      }
      input,
      textarea {
        width: 100%;
        height: 100%;
      }
    </style>
  </head>
  <body>
    <jsp:include page="../common/menubar.jsp" />

    <div class="outer" align="center">
      <br />
      <h1 align="center">게시판 수정하기</h1>
      <br />

      <table align="center" border="1">
        <input type="hidden" name="bno" value="${board.boardNo}">
        <tr>
          <td width="100">글번호</td>
          <td width="500">${board.boardNo}</td>
        </tr>
        <tr>
          <td>작성자</td>
          <td>${board.userId}</td>
        </tr>
        <tr>
          <td>제목</td>
         	<td>
		  	<textarea name="title" id="board-title">${board.boardTitle}</textarea>
			</td>
        </tr>
        <tr>
          <td>작성일</td>
          <td>${board.createDate}</td>
        </tr>
        <tr>
          <td>내용</td>
          <td height="100">
            <textarea type="text" name="content" id="board-content">
 ${board.boardContent}</textarea
            >
          </td>
        </tr>
      </table>
      <br />
      <div class="upadte-btn">
        <c:if test="${loginUser.userId == board.userId}">
          <button onclick="updatebtn(${board.boardNo})">수정하기</button>
          <button
            onclick="location.href='${pageContext.request.contextPath}/remove.bo?bno=${board.boardNo}'"
          >
            삭제하기
          </button>
        </c:if>
        <button
          onclick="location.href='${pageContext.request.contextPath}/list.bo?cpage=1'"
        >
          목록가기
        </button>
        <br />
        <br />
      </div>
      <script>
        function updatebtn(bno) {
        const titleArea = document.querySelector('#board-title'); // 제목 입력 필드
          const contentArea = document.querySelector('#board-content');
          $.ajax({
            url: '${pageContext.request.contextPath}/update.bo',
            type: 'post',
            data: {
              boardNo: bno,
              title : titleArea.value,
              content: contentArea.value
            },
            success: function (res) {
              let url = '${pageContext.request.contextPath}/list.bo?cpage=1'; 
              console.log(url); // 오타 수정
              location.replace(url);
            },
            error: function (error) {
              console.log('댓글 작성 ajax통신 실패');
            },
          });
        }
      </script>
    </div>
  </body>
</html>
