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
                                  <input type="file" name="files" onchange="selectFile(this);" />
                              </label>
                              <label> attachenmet에 여러개 첨부파일 첨부하기
                                  <input type="file" multiple="multiple" name="files" onchange="selectFile(this);" />
                              </label>

                          </div>
                          <button type="button" class="btns del_btn">파일추가</button>
                          <!--
                          <button type="button" onclick="removeFile(this);" class="btns del_btn"><span>삭제</span></button>
                          <button type="button" onclick="addFile();" class="btns fn_add_btn"><span>파일 추가</span></button>
                         -->
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
      <script>

          // 파일 선택
          function selectFile(element) {

              const file = element.files[0];
              const filename = element.closest('.file_input').firstElementChild;

              // 1. 파일 선택 창에서 취소 버튼이 클릭된 경우
              if ( !file ) {
                  filename.value = '';
                  return false;
              }

              // 2. 파일 크기가 10MB를 초과하는 경우
              const fileSize = Math.floor(file.size / 1024 / 1024);
              if (fileSize > 10) {
                  alert('10MB 이하의 파일로 업로드해 주세요.');
                  filename.value = '';
                  element.value = '';
                  return false;
              }

              // 3. 파일명 지정
              filename.value = file.name;
          }


          // 파일 추가
          function addFile() {
              const fileDiv = document.createElement('div');
              fileDiv.innerHTML =`
                  <div class="file_input">

                      <label>
                          <input type="file" name="files" onchange="selectFile(this);" />
                      </label>
                  </div>
                  <button type="button" onclick="removeFile(this);" class="btns del_btn"><span>삭제</span></button>
              `;
              document.querySelector('.file_list').appendChild(fileDiv);
          }


          // 파일 삭제
          function removeFile(element) {
              const fileAddBtn = element.nextElementSibling;
              if (fileAddBtn) {
                  const inputs = element.previousElementSibling.querySelectorAll('input');
                  inputs.forEach(input => input.value = '')
                  return false;
              }
              element.parentElement.remove();
          }
      </script>
  </div>
   <jsp:include page="../common/footer.jsp" />
</div>
</body>
</html>