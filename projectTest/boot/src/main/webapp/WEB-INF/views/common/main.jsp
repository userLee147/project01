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
    <div class="wrapper">
      <header class="header">
        <div id="head1">
          <img id="header_logo" src="../../../resources/img/로고.png" alt="로고" />
          <span>FreshFarm</span>
        </div>
        <div id="head2">
          <button id="head_btn1" onclick="info()">
            <a href="">
              <img src="../../../resources/img/info_green.png" alt="느낌표" />
              로그아웃
              <img src="../../../resources/img/right_small.png" alt="화살표" />
            </a>
          </button>
          <button id="head_btn2">
            <a href="">
              <img src="../../../resources/img/info_green.png" alt="느낌표" />사용 가이드
            </a>
          </button>
          <img src="../../../resources/img/bell.png " alt="알림종" />
          <img src="../../../resources/img/user.png " alt="사용자사진" />
        </div>
      </header>

      <main class="main">
        <nav id="nav">
          <ul>
            <li id="nav0">
              <a href="">
                <img id="logo" src="../../../resources/img/로고.png" alt="로고" />
                FreshFarm
              </a>
            </li>
            <li>
              <a id="link" href="">
                <img id="item" src="../../../resources/img/item2.png" alt="아이템" />
                <div>상품</div>
                <img src="../../../resources/img/Expand Arrow.png" alt="">
              </a>
            </li>
            <li>
              <a id="link" href="./productadd copy.html"
                ><img id="item" src="../../../resources/img/plus.png" alt="더하기" />
                <div>상품추가</div>
                <img src="../../../resources/img/Expand Arrow.png" alt=""></a
              >

            </li>


            <li>
              <a id="input" href="">
                <img id="input_item" src="../../../resources/img/download.svg" alt="입고" />입고</a
              >
            </li>
            <li>
              <a id="output" href="">
                <img
                  id="output_item"
                  src="../../../resources/img/upload.svg" alt="출고" />출고</a>
            </li>
            <li>
              <a id="output" href="">
                <img id="output_item"src="../../../resources/img/Shopping Bag.svg" alt="판매"/>판매</a>
            </li>
            <li>
              <a id="output" href="">
                <img id="output_item"src="../../../resources/img/Edit Delivery Terms.svg" alt="발주"/>발주</a>
            </li>
            <li>
              <a id="output" href="">
                <img id="output_item"src="../../../resources/img/Combo Chart.png" alt="분석"/>분석</a>
            </li>
                <li>
                  <a id="output" href="test.pos"> 포스기 연동</a>
                </li>
          </ul>
        </nav>
        <div class="content">
          <section id="main-section1">
            <div id="section1_1">
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
        </div>
      </main>
    </div>

  </body>
</html>
