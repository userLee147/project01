<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
	table * {margin:5px;}
	table {width:100%;}
</style> 
</head>
<body onload="init(${b.boardNo })">
	<jsp:include page="../common/header.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>게시글 상세보기</h2>
            <br>

            <a class="btn btn-secondary" style="float:right;" href="list.bo">목록으로</a>
            <br><br>

            <table id="contentArea" algin="center" class="table">
                <tr>
                    <th width="100">제목</th>
                    <td colspan="3">${b.boardTitle }</td>
                </tr>
                <tr>
                    <th>작성자</th>
                    <td>${b.boardWriter }</td>
                    <th>작성일</th>
                    <td>${b.createDate }</td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td colspan="3">
						<c:choose>
							<c:when test="${not empty b.originName }">
								<!-- case1 -->
                        		<a href="${b.changeName}" download="${b.originName }">${b.originName }</a>
                        	</c:when>
                        	<c:otherwise>
								<!-- case2 -->
								첨부파일이 없습니다.
							</c:otherwise>
						</c:choose>
                    </td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td colspan="3"></td>
                </tr>
                <tr>
                    <td colspan="4"><p style="height:150px;">${b.boardContent }</p></td>
                </tr>
            </table>
            <br>

   			
   			<!-- 수정하기, 삭제하기 버튼은 이 글이 본인이 작성한 글일 경우에만 보여져야 함 -->
            <div align="center">
            	<c:if test="${loginUser.userId eq b.boardWriter}">
	                <a class="btn btn-primary" onclick="postFormSubmit('edit')">수정하기</a>
	                <a class="btn btn-danger" onclick="postFormSubmit('delete')">삭제하기</a>
                </c:if>
            </div>
            <br><br>

            <form action="" method="POST" id="postForm">
                <input type="hidden" name="bno" value="${b.boardNo}">
            </form>

            <script>
                function postFormSubmit(type){
                    const formEl = document.querySelector("#postForm");
                    switch(type){
                        case "edit" : {
                            //formEl.action = "updateForm.bo";
                            $(formEl).attr("action", "updateForm.bo");
                        }break;
                        case "delete":{
                            //formEl.action = "delete.bo";
                            $(formEl).attr("action", "delete.bo")
                        }break;
                    }
                    
                    $(formEl).submit();
                }
            </script>
           
            
             <form action="" method="post" id="postForm">
           		<input type="hidden" name=bno value="7">
           		<input type="hidden" name="filePath" value="이미지.jpg">
             </form>
            
          
 
            <table id="replyArea" class="table" align="center">
                <thead>
                	<c:choose>
                		<c:when test="${empty loginUser }">
		                    <tr>
		                        <th colspan="2">
		                            <textarea class="form-control" readonly cols="55" rows="2" style="resize:none; width:100%;">로그인 후 이용 가능합니다.</textarea>
		                        </th>
		                        <th style="vertical-align:middle"><button class="btn btn-secondary disabled">등록하기</button></th>
		                    </tr>
	                	</c:when>
	                    <c:otherwise>
		                    <tr> 
		                        <th colspan="2">
		                            <textarea class="form-control" id="content" cols="55" rows="2" style="resize:none; width:100%;"></textarea>
		                        </th>
		                        <th style="vertical-align:middle"><button class="btn btn-secondary" onclick="addReply()">등록하기</button></th>
		                    </tr>
	                    </c:otherwise>
                    </c:choose>
                

                    
                    <tr>
                        <td colspan="3">댓글(<span id="rcount"></span>)</td>
                    </tr>
    
                </thead>
                <tbody >
                </tbody>
            </table>

            <script> //미완성 : 챗GPT 보고 콜백함수 정리하기!!!!
                function init(boardNo){
                    drawReplyList(boardNo);

                }


                function addReply(){
                    const content = document.querySelector("#content").value
                    const boardNo = ${b.boardNo}
                    const userId = "${loginUser.userId}"

                    insertReply({
                        refBno: boardNo,
                        replyWriter : userId,
                        replyContent : content
                    },drawReplyList)

                    }
                    /*
                    function insertReplytest(data){
                        $.ajax({
                            url: "/api/board/reply",
                            type: "post",
                            contentType: "application/json",
                            data: JSON.stringify(data),
                            success: function (res) {
                                console.log(res)
                            },
                            error: function (error) {
                                console.log(error)
                            }

                        })

                    }
                     */
                function insertReply(data, callback){
                    $.ajax({
                        url: "/api/board/reply",
                        type: "post",
                        data: data,
                        success: function (res) {
                            if(res ==="success"){
                                callback(data)
                            }else{
                                console.log("reply insert 실패")
                            }

                        },
                        error: function (error) {
                            console.log(error)
                        }

                    })

                }
                function getReplyList(boardNo,callback){
                    $.ajax({
                        url: "/api/board/replylist",
                        type:"get",
                        data : { boardNo : boardNo},
                        success : function (replyList){
                            console.log(replyList)
                            callback(replyList);
                        },
                        error : function (error){
                            console.log("실패")
                        }


                    })
                }
                function drawReplyList(data){
                    //TODO 1 댓글목록 가져와서 그리기
                    //data를 이용해서 댓글목록을 불러오고
                    //화면에 맞게 그려주기

                    getReplyList(data.boardNo,function (replyList){
                        str ="";
                        const drawArea = document.querySelector("#replyArea tbody")
                        const spanCount = document.querySelector("#rcount");
                        for(r of replyList){
                            str += "<tr>" +
                                "<td>" +r.replyWriter+"</td>" +
                                "<td>" +r.replyContent +"</td>" +
                                "<td>" +r.createDate +"</td>" +
                                "</tr>"

                        }

                        drawArea.innerHTML = str;
                        spanCount.innerText = replyList.length;
                    })

                }



            }
            </script>
        </div>
        <br><br>
    </div>
    
    <jsp:include page="../common/footer.jsp" />
</body>
</html>