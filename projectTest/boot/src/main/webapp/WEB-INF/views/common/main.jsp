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
                <img id="item" src="../../../resources/img/itembox.svg" alt="아이템" />
                <div>제품목록</div>
                <img src="../../../resources/img/Expand Arrow.png" id= "arrow" alt="화살표">
              </a>
            </li>
            <li>
              <a id="link" href="item.add"
                ><img id="item" src="../../../resources/img/plus.png" alt="더하기" />
                <div>상품추가</div>
                <img id= "arrow"src="../../../resources/img/Expand Arrow.png" alt="화살표"></a
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
                <img id="output_item"src="../../../resources/img/Combo Chart.svg" alt="분석"/>분석</a>
            </li>
                <li>
                  <a id="output" href="test.pos"> 포스기 연동</a>
                </li>
          </ul>
        </nav>
      </main>
    </div>

  </body>
</html>
