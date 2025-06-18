import React, { useEffect, useState } from 'react';
import { IoIosArrowBack } from 'react-icons/io';
import styled from 'styled-components';
import useMenuStore from '../store/MenuStore';

import { useNavigate } from 'react-router-dom';
import { NonebackgroudBtn } from '../styled/common';
import { IoSearch } from 'react-icons/io5';

const SearchMenu = () => {
  const { menuList, getMenuList } = useMenuStore();
  const [keyword, setKeyword] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    const fetchMenu = async () => {
      await getMenuList();
    };
    fetchMenu();
  }, []);

  const filteredData = keyword
    ? menuList.filter((item) => item.name.toLowerCase().includes(keyword.toLowerCase()))
    : [];

  return (
    <>
      <SearchSection>
        <NonebackgroudBtn onClick={() => navigate('/')}>
          <IoIosArrowBack size={30}></IoIosArrowBack>
        </NonebackgroudBtn>
        <input
          type="text"
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
          placeholder="메뉴를 입력하세요"
        />
      </SearchSection>

      <div>
        {keyword ? (
          filteredData.map((item) => 
            <ItemUl onClick={() => navigate(`/detail/${item.id}`)}>
            <ItemLi>
              <Img src={item.img} alt="" />
              {item.name}
            </ItemLi>
          </ItemUl>)
        ) : (
          <DivSearch>
            <IoSearch size={50}></IoSearch>
            <p>원하는 메뉴를 찾아보세요!</p>
          </DivSearch>
        )}
      </div>
    </>
  );
};

export default SearchMenu;

const SearchSection = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-around;
  align-items: center;
  text-align: center;

  padding: 0 10px;
  margin: 10px 0;

  input {
    width: 80%;
    font-size: 20px;
    padding: 10px;
    margin: 10px;
    border: none;
    background-color: #f1f3f5;
    border-radius: 8px;

    &:focus {
      outline: none;
      border: none;
      background-color: none;
    }
  }
`;
const DivSearch = styled.div`
  margin: 200px;
`;

const Img = styled.img`
  border-radius: 8px;
  width: 50px;
  height: 50px;
`;
const ItemUl = styled.ul`
  margin: auto;
  width: 80%;
`;
const ItemLi = styled.li`
  display: flex;
  justify-content: left;
  align-items: center;
  gap: 10px;
  font-size: 20px;
  margin: 10px;
`;

