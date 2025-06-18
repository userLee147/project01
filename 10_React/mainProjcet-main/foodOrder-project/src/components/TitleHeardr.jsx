import React from 'react';
import { useNavigate } from 'react-router-dom';
import { HeaderWrap } from '../styled/common';
import { IoMdLogIn } from 'react-icons/io';
import styled from 'styled-components';
import { FaRegUserCircle } from 'react-icons/fa';
import { HiOutlineUserCircle } from 'react-icons/hi2';

const TitleHeardr = () => {
  const navigator = useNavigate();

  return (
    <HeaderWrap>
      <HeadBtn onClick={() => navigator('/')}>오늘샌드</HeadBtn>
 
      <HeadBtn onClick={() => navigator('/')}>
        메인페이지 Go <IoMdLogIn size={30}></IoMdLogIn>
      </HeadBtn>
   

    </HeaderWrap>
  );
};

export default TitleHeardr;

const HeadBtn = styled.button`
  font-size: 20px;
  font-weight: bold;
  color: #ff5100;
  background: none;
  border: none;
  display: flex;
  justify-content: center;
  align-items: center;
`;
