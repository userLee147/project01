<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        body{
          font-family: 'Noto Sans KR',sans-serif;
          color:  #222;
          line-height: 1.5em;
          font-weight: 300;
          margin: 0;
          font-size: 15px;
          box-sizing: border-box;

        }
        a{
          color: #222;
          text-decoration: none;
        }
        .outline{
          border-bottom: 1px solid gray;
          width: 1000px;
          display: flex;
          margin: auto;

        }
        .item{
          width: 80%;

        }
        .item tr td{
          padding: 5px 10px;
        }
        .item tr:nth-child(1) td{
          display: flex;
          align-items: center;
          gap: 10px;
          height:10%;

        }
        .item tr:nth-child(1) {
          height: 10%;

        }
        .item tr:nth-child(2) span {
          font-size: 20px;
        }
        .item tr:nth-child(3) td  {
          padding-bottom: 20px;
        }
        .item tr td span, .item tr td p{
          text-align: left;

        }

        .photo{
          width: calc(1000px - 80%);
          position: relative;
          z-index: 1;
        }
        .photo>img{
          width: 100%;
          height: 90%;
        }
        .photo img{
          display: flex;
        }

        .photo a img{
          border: 6px solid rgba(9, 9, 9, 0);
          background-color: rgba(9, 9, 9, 0.459);
          border-radius: 5px;
          width: 20px;
          position: absolute;
          z-index: 2;
          top: 75%;
          right: 0%;

        }
    </style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>

	<div class="outer">
        <br>
        <h2 align="center">사진게시판</h2>
        <br>

        <c:if test="${loginUser != null}">
            <div align="right" style="width: 870px; margin-bottom: 6px;">
                <a href="enrollForm.pt" class="btn btn-sm btn-primary">게시글 작성</a>
            </div>
        </c:if>

        <div class="list-area">
            <c:choose>
                <c:when test="${not empty list}">
                    <c:forEach var="p" items="${list}">
                      <div class="items">
                        <div class="outline">
                          <table class="item">
                            <tr>
                              <td>
                                  <img src="img/user.png" width="50px" alt="">
                                  <span>${p.photoWriter}</span>
                              </td>
                            </tr>
                            <tr>
                              <td>
                              <span><b>${b.photoTitle}</b></span>
                              <p>board Content : ${p.photoContent}</p>
                            </td>
                            </tr>
                            <tr>
                              <td>
                                <span>조회수 : ${p.count}</span>
                                <span>댓글 : 00 </span>
                              </td>
                            </tr>
                            <tr>
                            </tr>
                          </table>

                            <div class="photo">
                              <img name="file" id="file1" src="" alt="">
                              <a href=""><img src="img/plus.png" alt=""></a>
                            </div>

                        </div>
                      </div>
                      </div>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <h1 align="center">게시글이 없습니다.</h1>
                    <c:if test="${loginUser != null}">
                        <div align="center">
                            <a href="${pageContext.request.contextPath}/enrollForm.pt" class="btn btn-sm btn-primary">게시글 작성</a>
                        </div>
                    </c:if>
                </c:otherwise>
            </c:choose>
        </div>

	</div>
</body>
</html>