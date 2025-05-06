import React from 'react'
import styled from 'styled-components';
import { NonebackgroudBtn } from '../styled/common';
import { Link } from 'react-router-dom';
import { IoMdLogIn } from 'react-icons/io';
import { FaRegUserCircle } from 'react-icons/fa';
import { HiOutlineUserCircle } from "react-icons/hi2";
import { useNavigate } from 'react-router-dom';

const Header = ({currentUser}) => {
  const navigator =useNavigate();
  
  const handleClick = () => {
    const someData = currentUser ;
    navigator(`/user/${currentUser.id}`, { state: someData }); // state에 데이터 담기
  };


  return (
    <HeaderWrap>
                <HeadTitle onClick={() => navigator('/')}>오늘샌드</HeadTitle>
                { 
                currentUser?.log ? (
                  <Container>
                    <p>내 정보</p>
                    <CircleBtn onClick={handleClick}>
                      <HiOutlineUserCircle size={30} color='white'></HiOutlineUserCircle>
                    </CircleBtn>
                  </Container>
                ) : (
                  <LoginBtn to="/login">
                    로그인을 해주세요 <IoMdLogIn size={30}></IoMdLogIn>
                  </LoginBtn>
                )}
    </HeaderWrap>
  )
}

export default Header

const HeaderWrap = styled.div`
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

const Container = styled.div`
display: flex;
align-items: center;
 justify-content: center;
  background-color: none;
p{
font-size: 18px;
font-weight: bold;
color: #ff5100 ;
}
`
const CircleBtn =styled.button`
  width: 30px;
  height: 30px;
  border-radius: 50%;  
  display: flex;
  align-items: center;
 justify-content: center;
 padding : 1px;
  background-color: #ff5100;
  margin : 12px;

`

const HeadTitle = styled.p`
font-size: 20px;
margin: 10px;
font-weight: 800;
color: #ff5100 ;
`

const LoginBtn = styled(Link)`
color: #ff5100 ;
gap: 5px;
 display: flex;
  align-items: center;
 justify-content: center;
  background-color: none;
  margin-right: 10px;
`;

