<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
 
</style>
</head>
<body nload="init(${board.boardNo})">

    <jsp:include page="../common/menubar.jsp" />

    <div class="outer" align="center">
        <br>
        <h1 align="center">게시판 상세조회</h1>
        <br>
		
        <table align="center" border="1">
            <tr>
                <td width="100">글번호</td>
                <td width="500">${board.boardNo} </td>
            </tr>
            <tr>
                <td>제목</td>
                <td>${board.boardTitle} </td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>${board.userId}</td>
            </tr>
            <tr>
                <td>조회수</td>
                <td>${board.count}</td>
            </tr>
            <tr>
                <td>작성일</td>
                <td>${board.createDate}</td>
            </tr>
            <tr>
                <td>내용</td>
                <td height="100">
                   ${board.boardContent}
                </td>
            </tr>
        </table>
        <div>
            <c:if test="${loginUser.userId eq board.userId}">
        	<button onclick="location.href='${pageContext.request.contextPath}/updateForm.bo?bno=${board.boardNo}'">수정하기</button>
            </c:if>
        	<button onclick="location.href='${pageContext.request.contextPath}/list.bo?cpage=1'">목록가기</button>
        </div>
	
        <br>

        <table align="center" border="1">
           <thead>
            <tr>
                <th>댓글작성</th>
                
                <!-- 댓글 작성의 일부분만 바꿀꺼니가 페이지 전체를 로딩하는 것보다 Ajax를 이용해서 댓글 부분을 바꾸는 것이 자원을 아겨서 사용할 수 있다? -->
                <!-- 그리고 form 태그 안에 있는 것 말고, 일반적인 name만 부여해서 데이터가 송신이 안됌.. ㅜㅜㅜ -->
                <th><textarea rows:"5" cols="30" id ="reply-content"></textarea></th>
                <th><button onclick="insertReply(${board.boardNo})">등록</button></th>
            </tr>
            
            
            <tr>
                <td colspan="3"><b>댓글(1)</b></td> <!-- fn:length(list) -->
            </tr>
            <thead>
            <tbody>

            </tbody>


                
        </table>
        <script>
        function init(bno){
            getReplyList(bno, function(data){
                drawReplyList(data);
            });
        }
            function insertReply(bno){
                const content = document.querySelector("#reply-content")
            $.ajax({
                url:"insert.re",
                type:"post",
                data:{
                    boardNo: bno,
                    content: content.value
                },
                success : function(res){
                    content.value = "";
                    getReplyList(bno,function(date){
                    	console.log("수정성공");
                        drawReplyList(data);	
                    });
                    

                },
                error:function(error){
                    console.log("댓글 insert ajax통신 실패");
                }
            });
            }
            function getReplyList(bno){
          
            $.ajax({
                url:"selectList.re",
                dataType:"json",
                data:{
                    boardNo: bno
                    
                },
                success : function(replyList){
                    callback(replyList)

                },
                error:function(error){
                    console.log("댓글 list ajax통신 실패");
                }
            });
            }
            function drawReplyList(replyList){
            	let str="";
            	for(r of replyList){
            		str += "<tr>"+
        					"<td>"+ r.userId+"</td>"+
        					"<td>"+ r.replyContent+"</td>"+
        					"<td>"+ r.createDate+"</td>"+
        					"</tr>";
        					
            	}
            	const replyBody = document.quesrSelector("#reply-area tbody");
            	replyBody.innerHtml=str;
            	
            }
            

        </script>
    </div>
</body>
</html>