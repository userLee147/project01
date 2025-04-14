<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <link rel="stylesheet" href="../../../resources/css/main.css">
    <style>
        body{
            box-sizing: border-box;
        }
      #section1 {
        width: 1200px;
        height: 800px;
        border: 1px solid black;
        display: flex;
        border-radius: 4px;
      }
      #section_head {
        width: 100%;
        height: 20%;
        border-radius: 4px 4px 0 0;
      }
    </style>
  </head>
  <body>
    <jsp:include page="../common/main.jsp" />
      <div>
        <p>제품목록 </p>

      </div>
      
              <div>
                <p>제품목록</p>
                <a href=""><img src="../../../resources/img/info240.png" alt="느낌표" /></a>
              </div>
              <div>
                <input type="text" placeholder="이름,바코드,속성검색" />
                <div>
                  <input type="checkbox" name="cnt" id="cnt" />
                  <label for="cnt">재고보유</label>
                </div>
              </div>
            </div>
            <div id="section1_2">
              <button id="section1_2_btn1">
                <a href="./productadd.html">
                  <img src="../../../resources/img/plus_white.png" alt="느낌표" />
                  제품추가
                  <img src="../../../resources/img/down_white.png" alt="화살표" />
                </a>
              </button>
              <button id="section1_2_btn2">
                <a href="">
                  <img src="../../../resources/img/database.png" alt="느낌표" />
                  데이터 관리
                </a>
              </button>
            </div>
          </section>
          <section id="main-section2">
            <div id="section2_1">
              <!-- 함수가 필요할것 같음 -->
              <p>등록한 제품이 없습니다. 제품을 추가해주세요</p>
              <button>
                <img src="../../../resources/img/plus_white.png" alt="" />
                <a href="./productadd.html">제품추가</a>
              </button>
            </div>
          </section>

  
  </body>
  </html>