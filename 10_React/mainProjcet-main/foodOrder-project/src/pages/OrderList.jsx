import React from 'react';
import useOrderStore from '../store/OrderStore';
import { Wrap } from '../styled/common';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { BounceLoader } from 'react-spinners';
import { useEffect } from 'react';
import TitleHeardr from '../components/TitleHeardr';

const OrderList = () => {
  const { loading, getOrderId, orderList, getOrderList } = useOrderStore();
  const location = useLocation();
  const currentUser = location.state;
  const navigator = useNavigate();

  useEffect(() => {
    const fetchMenu = async () => {
      await new Promise((resolve) => setTimeout(resolve, 1000)); // 디버깅용 딜레이
      getOrderList(); // 이 안에서 loading 처리해야 함
      console.log(orderList);
    };
    fetchMenu();
  }, []);

  return (
    <Wrap>
      {loading ? (
        <div>
          <BounceLoader size={100} color="#6a68ec" />
          <p>불러오는 중...</p>
        </div>
      ) : (
        <div>
          {orderList.length === 0 ? (
            <p>주문 내역이 없습니다.</p>
          ) : (
            <table>
              <thead>
                <tr>
                  <th>예약번호</th>
                  <th>예약날짜</th>
                  <th>예약내역</th>
                  <th>총금액</th>
                  <th>상태</th>
                </tr>
              </thead>
              <tbody>
                {orderList.map((order) => (
                  <tr key={order.id}>
                    <th>{order.id}</th>
                    <th>{order.date}</th>
                    <th>
                      {order.sandwich}
                      set
                    </th>
                    <th>{order.totalPrice}</th>
                    <th></th>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </div>
      )}
    </Wrap>
  );
};

export default OrderList;
