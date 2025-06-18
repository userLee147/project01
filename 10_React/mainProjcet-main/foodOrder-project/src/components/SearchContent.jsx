import React from 'react';
import styled from 'styled-components';
import { IoSearch } from 'react-icons/io5';
import '../App.css';

import { useNavigate } from 'react-router-dom';

const SearchContent = () => {
  const navigate = useNavigate();
  return (
    <SearchWrap>
      <TitleSection>
        <SearchTitle>오늘은 뭐 먹지? </SearchTitle>
        <SearchTitle>신선함이 가득한 오늘샌드로 </SearchTitle>
      </TitleSection>

      <SearchSection>
        <IoSearch size={50} color="#d7dbdf"></IoSearch>
        <SearchBox type="text" onFocus={() => navigate('/search')} placeholder="메뉴를 검색해보세요" />
      </SearchSection>
    </SearchWrap>
  );
};

export default SearchContent;

const SearchWrap = styled.div`
  display: flex;
  flex-direction: column;
`;

const TitleSection = styled.div`
  margin: 100px 20px 10px 20px;
  text-align: left;
`;
const SearchTitle = styled.p`
  font-size: 30px;
  font-weight: bold;
`;

const SearchSection = styled.div`

  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;

  padding: 0 10px;
  margin: 20px 10px ;
  background-color: #f1f3f5;
  border-radius: 8px;
`;

const SearchBox = styled.input`
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
`;
