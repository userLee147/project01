<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }
    .container {
      width: 700px;
      margin: 20px auto;
      border: 1px solid #ccc;
      padding: 20px;
      border-radius: 5px;
      background: #f9f9f9;
    }
    .table {
      width: 100%;
      border-collapse: collapse;
    }
    .table td {
      background: white;
      padding: 10px;
      border-bottom: 1px solid #ddd;
    }
    input, textarea {
      width: 100%;
      padding: 8px;
      margin-top: 5px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .file-list {
      margin-top: 10px;
    }
    .file-item {
      display: flex;
      align-items: center;
      margin-bottom: 5px;
    }
    .file-item input {
      flex: 1;
    }
    buttons {
      margin-top: 10px;
    }
    .btns fn_add_btn, btns del_btn {
      padding: 5px 10px;
      border: none;
      border-radius: 3px;
      cursor: pointer;
      margin-right: 5px;

    }
    .save { background: #007BFF; color: white; }
    .back { background: #ccc; }
    .add-file { background: #28a745; color: white; }
    .delete { background: #f44336; color: white; }
  </style>


</head>
<body>
<%@ include file="../common/header.jsp" %>
<div class="content">

  <br><br>
  <div class="container">
    <br>
    <h2 >사진게시글 작성하기</h2>
    <br>

      <form action="save.ph" method="post" autocomplete="off" enctype="multipart/form-data">

        <table class="table">
          <tr>
            <th ><label for="title">제목</label></th>
            <td ><input type="text" id="title" class="form-control" name="boardTitle" required></td>

            <th><label for="createDate">작성일</label></th>
            <td><input type="text" id="createDate" class="form-control" name="createDate"></td>

          </tr>
          <tr>
            <th ><label for="writer">작성자</label></th>
            <td colspan="3"><input type="text" id="writer" class="form-control" value="${loginUser.userId }" name="boardWriter" readonly></td>
          </tr>
          <tr>
            <th ><label for="content">내용</label></th>
            <td colspan="3"><textarea id="content" class="form-control" rows="10" style="resize:none;" name="boardContent" required></textarea></td>
          <tr>
              <th>첨부파일</th>
              <td colspan="3">
                  <div class="file_list">
                      <div>
                          <div class="file_input">
                              <label>
                                    단일파일 올리기
                                    <input type="file" name="files" onchange="selectFile(this);" />
                              </label>
                              <label>
                                    여려개 파일올리기
                                    <input type="file" multiple="multiple" name="files" onchange="selectFile(this);" />
                              </label>
                          </div>
                  </div>
              </td>
          </tr>
        </table>
        <br>
        <div align="center">
          <button type="submit" class="btn btn-primary">작성하기</button>
          <button type="reset" class="btn btn-primary">취소하기</button>
        </div>
      </form>
  </div>
   <jsp:include page="../common/footer.jsp" />
</div>
</body>
</html>