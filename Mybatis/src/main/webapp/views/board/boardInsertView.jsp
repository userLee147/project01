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
        color: black;
      }
      input,
      form textarea {
        width: 100%;
        height: 100%;
      }
      button {
        background-color: white;
      }
      tr td:nth-child(1),
      h1 {
        color: white;
      }
    </style>
  </head>

  <body>
    <jsp:include page="../common/menubar.jsp" />

    <div class="outer" align="center">
      <br>
      <h1 align="center">게시판 작성하기</h1>
      <br>
      
      <form action="${pageContext.request.contextPath}/insert.bo" method="post">
        <table align="center" border="1">
          <tr>
            <td width="100">글번호</td>
            <td width="500" style="color: white">
              자동으로 생성됩니다.
            </td>
          </tr>
          <tr>
            <td>작성자</td>
            <td style="color: white">${loginUser.userId}</td>
          </tr>
          <tr>
            <td>제목</td>
            <td><input type="text" name="title" /></td>
          </tr>
          <tr></tr>
          <tr>
            <td>내용</td>
            <td height="100">
              <textarea type="text" name="content"></textarea>
            </td>
          </tr>
        </table>

        <br>
        <div align="center">
          <button type="reset">취소하기</button>
          <button type="submit">작성하기</button>
        </div>
      </form>
    </div>
  </body>
</html>
