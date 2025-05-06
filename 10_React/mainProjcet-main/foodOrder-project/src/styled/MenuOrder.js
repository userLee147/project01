import styled from 'styled-components';
import { Link } from 'react-router-dom';

export const CardContainer = styled.div`

 width: 100%; 
 padding: 8px;
 margin-top: 5px;
  margin-bottom : 20px;

`
export const FormTable = styled.table`
 width: 100%; 
 border-collapse:collapse;
 text-align: left;



 tr, th{
 padding-left : 10px;
 }

 th, td{
  
 border-bottom : 1px solid rgb(229, 229, 229);
 }

 th{
 width : 20%}
 input {

  width: calc(100% - 10px);
 margin : 10px;
border-radius: 4px ;
border : none;
  background-color: rgb(229, 229, 229);
  padding : 10px
 }

 tr{
 border-top : 1px solid rgb(229, 229, 229);
  }
`

export const OrderTable = styled.table`
 width: 100%; 
 border-collapse:collapse;
 text-align: left;
 margin-bottom : 10px;

 tr, th{
 padding-left : 10px;
  border-bottom : 1px solid rgb(229, 229, 229);
 }

  th{
 width : 20%}

 tr{
 border-top : 1px solid rgb(229, 229, 229);
  }

 input {
  width: calc(100% - 10px);
  margin : 10px;
  border : none;
  background-color: rgb(229, 229, 229);
  border-radius: 4px ;
  padding : 10px
  }

  select {
  margin : 10px;
  }

  input[type='checkbox'] {

  width: 10%; 
  padding : 5px


 th, td{
 border-top : 1px solid rgb(255, 255, 255);
 padding : 8px
 }

 input[type='number']{
 border : none;
 background-color: rgb(229, 229, 229);
 }

`
export const TableTd = styled.td`
padding : 20px;
text-align : center;
 background-color: rgb(255, 255, 255);
font-weight: bold;
p{color : #f26d2;}
`
export const TableTitle = styled.h2`
text-align : left;
padding-left : 10px;
margin: 20px;

`

export const FormTableTr =styled.tr`

`