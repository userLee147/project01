
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
    <section class="pos-searchitem">
      
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
      <div class="itemList">
        <div class="itemList-outer">
          <table class ="item-table">
            <thead>
              <tr>
                <th>상품번호</th>
                <th>상품명</th>
                <th>수량</th>
                <th>금액</th>
                <th>추가</th>
              </tr>
            </thead>
            <tbody >
              <tr>
                <td>1</td>
                <td>달콤프란찌(딸기)</td>
                <td>1</td>
                <td>8000</td>
                <td><img src="../../../resources/icons/추가아이콘.png" onclick="addList(this)" alt=""></td>
              </tr>
              <tr>
                <td>2</td>
                <td>달콤프란찌(초코)</td>
                <td>1</td>
                <td>8000</td>
                <td><img src="../../../resources/icons/추가아이콘.png" onclick="addList(this)" alt=""></td>
              </tr>
              <tr>
                <td>3</td>
                <td>달콤프란찌(바나나)</td>
                <td>1</td>
                <td>8000</td>
                <td><img src="../../../resources/icons/추가아이콘.png" onclick="addList(this)" alt=""></td>
              </tr>
              <tr>
                <td>3</td>
                <td>달콤프란찌(바나나)</td>
                <td>1</td>
                <td>10000</td>
                <td><img src="../../../resources/icons/추가아이콘.png" onclick="addList(this)" alt=""></td>
              </tr>

            </tbody>
          </table>
        </div>
      </div>

      <div class="enteritem">
        <div class="enteritem-outer">
          <div class="enteritem-inner">
            <div class="enter-title">
              상품 번호입력
            </div>
            <div class="enter-content">
              <div class="enter1">
                <div>1</div>
                <div>2</div>
                <div>3</div>
                <div>4</div>
                <div>5</div>
  
              </div>
              <div class="enter2">
                <div>6</div>
                <div>7</div>
                <div>8</div>
                <div>9</div>
                <div>0</div>
              </div>
            </div>
            <div class="enter-show">
                <div>검색하기</div>
                <div>c</div>
            </div>
          </div>
        </div>

      </div>

    </section>
    
    <section class="pos-payitem">
      
      <div class="payList-head">
        <div class="payList-title">
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
          <tbody id="tbshow">

          </tbody>
        </table>
      </div>

      <div class="payCount" >
        <div class="payCount-content">
          <p>결제금액</p>
          <p id="totalcount">총액 : </p>
        </div>
        <button class="pay-btn" type="submit">결제하기</button>
      </div>
    </section>
</div> 
<script>
  function addList(this_tb){
    const objRow = document.all("tbshow").insertRow();
    const test = this_tb.closest('tr');
    var rowNum = test.childElementCount;

    for (var i =0; i < rowNum; i++){
      var addrow;
      if(i==0){
        addrow = objRow.insertCell();
        addrow.innerHTML="<img src='../../../resources/icons/삭제아이콘.png' alt='삭제' onclick='deleteList(this)'>"

      }else if(i == 3){
        addrow = objRow.insertCell();
        const num = test.cells[i-1].innerHTML; 
        addrow.innerHTML = "<input type='text' onchange='priceCount()' value ='"+ num +"'>";
      }else{
        addrow = objRow.insertCell();
        addrow.innerHTML = test.cells[i-1].innerHTML; 
      }
    }

    priceCount();

  }

  function deleteList(this_tb){
    const test = this_tb.closest('tr');
    test.remove();
    
    priceCount();

  }

  function priceCount(){
    const table = document.getElementById('tbshow').getElementsByTagName('tr')
    const total = document.getElementById('totalcount');
    var sum =0;
    

    for(i=0;i<table.length;i++){
      var cnt = table[i].cells[3].querySelector('input').value;
      var price = table[i].cells[4].innerText;
      sum += cnt*price;
      console.log(cnt)
    }
    console.log(sum)

    total.innerText = "총액 : " + sum;
  }
</script>
</body>
</html>
