import React from 'react';

import { useLocation } from 'react-router-dom';
import { IoIosArrowForward } from 'react-icons/io';
import { IoCardOutline } from 'react-icons/io5';
import { FaRegCalendarCheck } from 'react-icons/fa6';
import useMenuStore from '../store/MenuStore';
import { Wrap, NonebackgroudBtn,HeaderWrap, CommonBtn,CommonBtn2 } from '../styled/common';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import useUserStore from '../store/UserStore';

const UserPage = () => {
  const location = useLocation();
  const currentUser = location.state;
  const navigator = useNavigate()
  
  const {logout} = useUserStore();
  const handleLogout =() => {
    logout();
    navigator('/')
  }


  return (
    <>
      <Wrap>
        <HeaderWrap>

          <HeadTitle>
          {currentUser.id} 님
          <NonebackgroudBtn onClick={() => navigator('/userEdit', {state: currentUser}) }>
          <IoIosArrowForward></IoIosArrowForward>
          </NonebackgroudBtn>
          </HeadTitle>
          


        </HeaderWrap>

        {/* 주문 정보 */}
        <div>
          <OrderTable>
            <colgroup>
            <col width={"5%"} />
            <col width={"80%"} />
            <col width={"10%"} />
            </colgroup>
            <thead>
              
            </thead>
            <tbody>
              <tr>
              <th colSpan={3}>
                <p>주문정보</p>
              </th>
              </tr>

              <tr>
                <td>
                  <FaRegCalendarCheck></FaRegCalendarCheck>
                </td>
                <td>예약내역</td>
                <td>
                  <button onClick={()=> navigator(`/order/${currentUser.id}`,{ state: currentUser})} >
                    <IoIosArrowForward></IoIosArrowForward>
                  </button>
                </td>
              </tr>
              <tr>
                <td>
                  <IoCardOutline></IoCardOutline>
                </td>
                <td>결제내역</td>
                <td>
                  <NonebackgroudBtn>
                    <IoIosArrowForward></IoIosArrowForward>
                  </NonebackgroudBtn>
                </td>
              </tr>
              <tr>
                <td>
                  <IoCardOutline></IoCardOutline>
                </td>
                <td>준비중</td>
                <td>
                  <NonebackgroudBtn>
                    <IoIosArrowForward></IoIosArrowForward>
                  </NonebackgroudBtn>
                </td>
              </tr>
            </tbody>
          </OrderTable>
        </div>
        <div>
            <CommonBtn2 onClick={handleLogout} >로그아웃</CommonBtn2>
            <CommonBtn to="/">홈으로</CommonBtn>
          </div>
      </Wrap>
    </>
  );
};

export default UserPage;

const OrderTable = styled.table`
  width: 100%;
  margin: 20px 10px;
  border-collapse: collapse;
  text-align: left;

  p{
  margin : 10px;
  font-size: 18px;
  font-weight: bold;
  }

  td {
    padding: 8px;
  }


  td:last-child {
    text-align: right;
  }

  button {
  background: none;

  }
`
const HeadTitle = styled.div`
  margin-left: 10px;
  
  
  font-size: 24px;
  font-weight: bold;
  
`