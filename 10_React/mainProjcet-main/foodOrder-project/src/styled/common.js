import styled from 'styled-components';
import { Link } from 'react-router-dom';

//주황 #ff5100

export const Wrap = styled.div`
  width: 100%;
  min-height: 100vh;
  box-sizing: border-box;
  box-shadow: 0 1px 2px rgba(0, 0, 0, 0.07), 0 2px 4px rgba(0, 0, 0, 0.07), 0 4px 8px rgba(0, 0, 0, 0.07),
    0 8px 16px rgba(0, 0, 0, 0.07), 0 16px 32px rgba(0, 0, 0, 0.07), 0 32px 64px rgba(0, 0, 0, 0.07);
`;

export const CommonBtn = styled(Link)`
  padding: 10px 40px;
  margin: 5px;
  border: 1px solid #ff5100;
  border-radius: 8px;
  color: #ff5100;
  &:hover {
    opacity: 0.9s;
    color: white;
    background-color: #ff5100;
  }
`;

export const CommonBtn2 = styled.button`
  padding: 10px 40px;
  margin: 5px;
  border: 1px solid #ff5100;
  border-radius: 8px;
  color: #ff5100;
  &:hover {
    opacity: 0.9s;
    color: white;
    background-color: #ff5100;
  }
`;

export const NonebackgroudBtn = styled.button`
  background: none;

  &:hover {
    outline: none;
    border: none;
    background-color: none;
  }
`;

export const SearchSection = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;

  padding: 0 10px;
  margin: 10px 0;
  background-color: #f1f3f5;
  border-radius: 8px;

  input {
    width: 90%;
    font-size: 20px;
    padding: 10px;
    margin: 10px;
    border: none;
    background: none;

    &:focus {
      outline: none;
      border: none;
      background-color: none;
    }
  }
`;

export const NavDiv = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 40px 20px;
`;
export const NavButton = styled.button`
  width: 100px;
 background-color: white;
  padding: 16px 0px 16px 0;
  margin: 10px;
  backgroud : white;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  color: black;
  gap: 5px;

  &:hover{
    cursor: pointer;}
`;

export const HeaderWrap = styled.div`
width:  100%;
border: none;
display: flex;
align-items: center;
justify-content: space-between;

  position: sticky; 
  top:0;   // 고정 위치
  height: 60px;       // 적절한 높이 설정
  background-color: white; // 배경 설정 (스크롤 시 투명하면 안 보일 수 있음)
  z-index: 1000;      // 다른 요소보다 위에 표시



`