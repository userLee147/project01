import React from 'react';
import useMenuStore from '../store/MenuStore';
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Header from '../components/Header';
import styled from 'styled-components';
import { IoSearch } from 'react-icons/io5';
import { Swiper, SwiperSlide } from 'swiper/react';
// import required modules
import { Pagination, EffectCoverflow } from 'swiper/modules';

// Import Swiper styles

import 'swiper/css/pagination';
import 'swiper/css/effect-coverflow';
import'../css/stylesmenu.css';
import { Wrap } from '../styled/common';


export const MenuList = () => {
  const { menuList, getMenuList } = useMenuStore();
  const [keyword, setKeyword] = useState('');
  const navigate = useNavigate();

  useEffect(() => {
    const fetchMenu = async () => {
      await getMenuList();
    };
    fetchMenu();
  }, []);

  const filteredData = menuList.filter((item) => item.name.toLowerCase().includes(keyword.toLowerCase()));

  return (
    <Wrap>

  <Header></Header>
        <MenuListContainer>
          <p>메뉴소개 </p>
            <SearchSection>
  
            <IoSearch size={50} color="#d7dbdf"></IoSearch>
            <SearchBox type="text" onChange={(e) => setKeyword(e.target.value)} placeholder="메뉴를 검색해보세요" />

            </SearchSection>


        </MenuListContainer>

        <SwiperContainer>
          <Swiper
            loop={true}
            effect={'coverflow'}
            grabCursor={true}
            centeredSlides={true}
            slidesPerView={'auto'}
            coverflowEffect={{
              rotate: 0,
              stretch: 0,
              depth: 100,
              modifier: 1,
              slideShadows: true,
            }}
             //
            pagination={true}
            modules={[EffectCoverflow, Pagination]}
            className="menu-swiper"
          >
            {filteredData.map((item) => (
              <SwiperSlide key={item.id}>
                <img src={item.img} alt="" />
                <ItemDiv>
                  <ItemText onClick={() => navigate(`/detail/${item.id}`)}> {item.name}</ItemText>
                  <ItemText>💲{item.price.toLocaleString()}원</ItemText>
                  <ItemTexts>{item.description}</ItemTexts>
                </ItemDiv>
              </SwiperSlide>

            ))}
          </Swiper>
        </SwiperContainer>

    </Wrap>
  );
};

export default MenuList;



const SwiperContainer = styled.div`
  justify-content: center;
  align-items: center;

  h3 {
    font-weight: bold;
  }
`;

const MenuListContainer = styled.div`
  
  text-align: center;
  margin-bottom : 20px;
  p {
    font-size: 24px;
    font-weight: bold;
    text-align: center;
    color: black;
    margin: 20px;
  }
`;

const SearchSection = styled.div`
width : calc(100% - 20px);
  display: flex;
  align-items: center;
  text-align: center;

  padding: 0 10px;
  margin: 20px 10px ;
  background-color: #f1f3f5;
  border-radius: 8px;
`;

const SearchBox = styled.input`

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



const ItemDiv = styled.div`
  justify-content: center;
  align-items: center;
  margin: 5px;
`;
const ItemText = styled.p`
  font-size: 20px;
  font-weight: bold;
`;

const ItemTexts = styled.p`
padding: 0px 30px;

`;

