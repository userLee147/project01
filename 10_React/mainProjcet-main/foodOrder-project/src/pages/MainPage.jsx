import React from 'react';

import styled from 'styled-components';
import { Link, useNavigate } from 'react-router-dom';
import useUserStore from '../store/UserStore';
import Header from '../components/Header';
import SearchContent from '../components/SearchContent';

import { NavDiv, NavButton, Wrap } from '../styled/common';

import { FaStore } from 'react-icons/fa';
import { PiForkKnife } from 'react-icons/pi';
import { PiMegaphoneBold } from 'react-icons/pi';
import { LuSandwich } from 'react-icons/lu';

import { Swiper, SwiperSlide } from 'swiper/react';
// import required modules
import { Autoplay, Pagination } from 'swiper/modules';

// Import Swiper styles
import 'swiper/css';
import 'swiper/css/pagination';
import '../css/styles.css';

const MainPage = () => {
  const { currentUser } = useUserStore();
  const navigator = useNavigate();

  const checkUser = () => {
    const someData = currentUser;
    if (currentUser?.id) {
      navigator('/order', { state: someData });
    } else {
      alert('로그인 후 이용가능합니다.');
    }
  };

  return (
    <Wrap>

      <Header currentUser={currentUser}> </Header>
      <SearchContent> </SearchContent>
      <SwiperContainer>
        <Swiper
          loop={true}
          centeredSlides={true}
          autoplay={{
            delay: 2500,
            disableOnInteraction: true,
          }}
          pagination={{
            dynamicBullets: true,
          }}
          modules={[Pagination, Autoplay]}
          className="main-swiper"
        >
          <SwiperSlide>도시락 세트 할인중 </SwiperSlide>
          <SwiperSlide>광고배너 준비중</SwiperSlide>
          <SwiperSlide>광고배너 준비중</SwiperSlide>
        </Swiper>
      </SwiperContainer>

      <NavDiv>
        <NavButton onClick={()=>navigator("/menu",{currentUser})}>
          <PiForkKnife color="black" size={30}></PiForkKnife>
          메뉴정보
        </NavButton>

        <NavButton onClick={checkUser}>
          <FaStore color="black" size={30}></FaStore>
          <p>단체주문</p>
        </NavButton>

        <NavButton >
          <PiMegaphoneBold color="black" size={30}></PiMegaphoneBold>
          <p>공지</p>
        </NavButton>

        <NavButton>
          <LuSandwich color="black" size={30}></LuSandwich>
          <p>준비중</p>
        </NavButton>
      </NavDiv>

      <div>
        <ContentTitle>TodaySand Orders</ContentTitle>
        <CardWrapper>
          <Image src="/public/img/유치원선생님.JPG" />
          <TextOverlay>
            <Title>샌드위치set NO1</Title>
            <Description>유치원선생님들에게 보내드린 맛난 간식세트</Description>
          </TextOverlay>
        </CardWrapper>
        <CardWrapper>
          <Image src="/public/img/버스대절.jpg" />
          <TextOverlay>
            <Title>샌드위치set NO1</Title>
            <Description>강남 결혼식 답례품으로 샌드위치세트 준비하세요</Description>
          </TextOverlay>
        </CardWrapper>
      </div>
    </Wrap>
  );
};

export default MainPage;

const SwiperContainer = styled.div`
  margin: 10px;
  justify-content: center;
  align-items: center;
`;



const ContentTitle = styled.p`
  font-size: 24px;
  font-weight: bold;
  text-align: left;
  color: black;
  margin: 20px;
`;

const CardWrapper = styled.div`
  position: relative;
  max-width: 100%;
  margin: 10px;
`;

const Image = styled.img`
  width: 100%;
  height: auto;
  display: block;
  border-radius: 10px;
`;

const TextOverlay = styled.div`
  width: 100%;
  padding: 10px;
  padding-top: 150px;
  background: linear-gradient(to top, #ffffff 0%, rgba(255, 255, 255, 0) 90%);
  position: absolute;
  bottom: 0px;

  color: black;
  text-align: left;
`;

const Title = styled.h3`
  margin: 0;
  font-size: 22px;
  padding-left: 10px;
`;

const Description = styled.p`
  margin: 4px 0 20px 0;
  font-size: 16px;
  padding-left: 10px;
`;
