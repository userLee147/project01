
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
<link rel="stylesheet" href="../../../resources/css/pos.css">
  <style>
    body{
      box-sizing: border-box;
    }
    *{
  
      margin: 0px;
      padding: 0px;
    }
    .outer{
      width: 1024px;
      height: 768px;
      border: 1px solid black;
      margin: auto;
    }
  </style>
</head>
<body>
<div class="outer">
  <div class="header">
    <p>편이덮밥 pos</p> 
    <div>
      <p >판매일자 : 자바스크립 필요</p>
      <img src="../../../resources/img/엑스.png" alt="엑스">
    </div>

  </div>
  <div class="main">
    <section class="itemList">
      
      <!--searchBar : 상품목록 검색창 -->
      <div class="searchBar">
        <div class="searchBar-outer">
          <p>상품목록</p>
          <div class="searchBar-div">
            <img src="../../../resources/img/Search.png" alt="돋보기">
            <input type="text" placeholder="상품번호입력" >
          </div>
        </div>
      </div>

      <!--searchItem : 상품목록  -->
      <div class="searchItem">
        <div class="searchItem-outer">
          <table class ="search-table">
            <thead>
              <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>수량</th>
                <th>추가</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>달콤프란찌(딸기)</td>
                <td>1</td>
                <td>버튼<img src="" alt=""></td>
              </tr>
              <tr>
                <td>2</td>
                <td>달콤프란찌(초코)</td>
                <td>1</td>
                <td>버튼<img src="" alt=""></td>
              </tr>
              <tr>
                <td>3</td>
                <td>달콤프란찌(바나나)</td>
                <td>1</td>
                <td>버튼<img src="" alt=""></td>
              </tr>
              <tr>
                <td>3</td>
                <td>달콤프란찌(바나나)</td>
                <td>1</td>
                <td>버튼<img src="" alt=""></td>
              </tr>
              <tr>
                <td>3</td>
                <td>달콤프란찌(바나나)</td>
                <td>1</td>
                <td>버튼<img src="" alt=""></td>
              </tr>
              <tr>
                <td>3</td>
                <td>달콤프란찌(바나나)</td>
                <td>1</td>
                <td>버튼<img src="" alt=""></td>
              </tr>
              <tr>
                <td>3</td>
                <td>달콤프란찌(바나나)</td>
                <td>1</td>
                <td>버튼<img src="" alt=""></td>
              </tr>
              <tr>
                <td>3</td>
                <td>달콤프란찌(바나나)</td>
                <td>1</td>
                <td>버튼<img src="" alt=""></td>
              </tr>

            </tbody>
          </table>
        </div>
      </div>

      <div class="calculate">
        <div class="calclate-outer">
          <table class="cal-table">
            <tr>
              <td>1</td>
              <td>2</td>
              <td>3</td>
              <td>4</td>
              <td>5</td>
              <td>c</td>
  
            </tr>
            <tr>
              <td>6</td>
              <td>7</td>
              <td>8</td>
              <td>9</td>
              <td>0</td>
              <td class="enter" >검색하기</td> 
            </tr>
          </table>
        </div>
      </div>

    </section>
    
    <section class="payList">
      
      <div class="payList-head">
        <div class="payList-subtitle">
          <p>POS-Recipt</p>
        </div>
        <p>결제목록</p>
      </div>

      <div class="payTable-outer">
        <table class="payTable">
          <thead>         
             <tr>
                <th>삭제</th>
                <th>상품번호</th>
                <th>상품명</th>
                <th>수량</th>
                <th>금액</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td >버튼<img src="" alt=""></td>
              <td>1</td>
              <td>달콤프란찌(딸기)</td>
              <td><input type="text"></td>
              <td>8,000</td>  
            </tr>
            <tr>
              <td>버튼<img src="" alt=""></td>
              <td>2</td>
              <td>달콤프란찌(초코)</td>
              <td><input type="text"></td>
              <td>8,000</td>  
            </tr>
            <tr>
              <td>버튼<img src="" alt=""></td>
              <td>2</td>
              <td>달콤프란찌(초코)</td>
              <td><input type="text"></td>
              <td>8,000</td>  
            </tr>
            <tr>
              <td>버튼<img src="" alt=""></td>
              <td>2</td>
              <td>달콤프란찌(초코)</td>
              <td><input type="text"></td>
              <td>8,000</td>  
            </tr>
            <tr>
              <td>버튼<img src="" alt=""></td>
              <td>2</td>
              <td>달콤프란찌(초코)</td>
              <td><input type="text"></td>
              <td>8,000</td>  
            </tr>

          </tbody>
        </table>
      </div>

      <div class="payCount" >
        <div class="payCount-content">
          <p>결제금액</p>
          <p>총액 : </p>
        </div>
        <button class="pay-btn" type="submit">결제하기</button>
      </div>
    </section>
</div> 

</body>
</html>
