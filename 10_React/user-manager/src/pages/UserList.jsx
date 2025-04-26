import React, { useContext, useEffect, useState } from 'react';
import { Link, useLocation, useNavigate, useParams } from 'react-router-dom';
import styled from 'styled-components';
import UserDetail from './UserDetail';
import Useritem from '../components/Useritem';
import { useUser } from '../components/context/UserContext';
import { ThemeContext } from '../components/context/ThemeContext';

const Wrap = styled.div`
    width: 500px;
    border: 1px solid #c5c5c5;
  background-color: white;
`

const Header = styled.header`
  display: flex;
  height: 50px;
  padding: 10px 10px 10px 20px;
  align-items: center;
  font-size: 16px;
  font-weight: bold;
  border-bottom: 1px solid #c5c5c5;
  background-color: #e7e7ee;
`;
const HeaderDiv = styled.div`
  display : flex;
`
const HeaderTitle = styled.p`
  display: flex;

`;
const BlueP = styled.p`
  padding : auto;
  color: #0057ff;
`;

const MainDiv = styled.section`
  width: 100%;
  border-bottom: 1px solid #c5c5c5;
  display: flex;
`;

const ImgDiv = styled.div`
  justify-content: center;
  align-items: center;
`;
const Img = styled.img`
  width: 100px;
  height: 100px;
  margin: 20px 40px;
`;
const ImgP = styled.p`
  margin-bottom: 20px;
`;

const ContentDiv1 = styled.div`
  width: 70%;
  margin-left: 20px;
  display: flex;
  flex-direction: column; 
  align-items: flex-start; 
`;

const AdminP1 = styled.p`
  display: flex;
  margin-top: 30px;
  font-size: 15px;
  font-weight: bolder;
`;

const AdminP2 = styled.p`
  display: flex;
  font-size: 25px;
  font-weight: bolder;
`;

const ContentBtn = styled.button`
  background-color: white;
  border: 1px solid #c5c5c5;
  width: 90%;
  height: 50px;
  margin-top: 10px;
`;


const Section2 =styled.section`
  width: 100%;
  height: 100%;
  background-color: white;
  text-align: left;
`
const ContentTitle = styled.p`
  padding: 10px 10px 10px 20px;
  font-size: 16px;
  font-weight: bold;
  background-color: #e7e7ee;
  border-bottom: 1px solid #c5c5c5;
`

const CardList = styled.div`
  display: flex;
  gap: 10px;
    // box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
    // transition: all 0.3s cubic-bezier()cubic-bezier(.25,.8, 0.25, 1);

  :hover {
    box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
  }
`;



const UserList = () => {
  const { users } = useUser();
  const { userInfo, setUserInfo } = useState();
  const { isDark, setIsDark } = useContext(ThemeContext);

  const navigate = useNavigate();
  const handleClick = () => {
    navigate('/user/');
  };

  const toggleTheme = () => {
    setIsDark(!isDark);
  };

  return (
    <>
    <Wrap>
    <Header>
        <HeaderDiv>
          <BlueP> 관리자&nbsp; </BlueP>
          <HeaderTitle> 님 환영합니다 </HeaderTitle>
        </HeaderDiv>
      </Header>
      <MainDiv
        style={{
          backgroundColor: isDark ? '#b7d3f8' : '#fbfbfd',
        }}
      >
        <ImgDiv>
          <Img
            src="/public/static/iconmonstr-user-circle-thin-240.png"
            alt=""
          />
          <ImgP> 🔵 온라인</ImgP>
        </ImgDiv>

        <ContentDiv1>
          <AdminP1>관리자</AdminP1>
          <AdminP2> Admin 대표</AdminP2>
          <ContentBtn
           onClick={() => handleClick()}
          >유저등록
          </ContentBtn>

        </ContentDiv1>

      </MainDiv>
      <Section2>
        <ContentTitle>유저목록페이지</ContentTitle>
          {users.map((userItem) => (
            <Useritem key={userItem.id} userItem={userItem} />
          ))}
      </Section2>
    </Wrap>
      
    </>
  );
};

export default UserList;
