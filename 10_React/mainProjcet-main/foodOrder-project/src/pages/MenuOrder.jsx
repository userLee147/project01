import React, { useRef, useEffect, useState } from 'react';


import * as yup from 'yup';
import { yupResolver } from '@hookform/resolvers/yup';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';
import { FormTable, OrderTable, TableTd, TableTitle, CardContainer } from '../styled/MenuOrder';
import useOrderStore from '../store/OrderStore';
import { useLocation } from 'react-router-dom';


// 유효성 검사 스키마
const schema = yup.object().shape({
  name: yup.string().required('이름은 필수입니다.'),
  phone: yup.string().required('연락처는 필수입니다.'),
  email: yup.string().email().required('이메일을 입력하세요.'),
  quantity: yup.number().required().min(20, '수량은 20 이상이어야 합니다.'),
  sandwich: yup.boolean(),
  drink: yup.boolean(),
  option: yup.boolean(),
  address: yup.string(),
  date: yup.string(),
});

const MenuOrder = () => {
  const location = useLocation();
  const currentUser = location.state;

  const navigate = useNavigate();
  const { addOrder  } = useOrderStore();
   const [checkedItems, setCheckedItems] = useState({
    sandwich: false,
    drink: false,
    option: false,
    quantity: 20,
  });



  const [selectedSandwich, setSelectedSandwich] = useState('햄치즈에그');
  const [selectedDrink, setSelectedDrink] = useState('1000');
  const [selectedOption, setSelectedOption] = useState('0');
  const [quantity, setQuantity] = useState(20);
  const [totalPrice, setTotalPrice] = useState(0);

  const sandwichPrices = {
    햄치즈에그: 3500,
    크래미와사비: 3700,
    단호박: 3900,
    치킨텐더: 4100,
    함박스테이크: 4300,
  };

  const {
    register,
    handleSubmit,
    setValue,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(schema),
  });

  useEffect(() => {
    if (currentUser) {
      setValue('name', currentUser.name || '');
      setValue('email', currentUser.email || '');
    }
  }, [currentUser]);

  useEffect(() => {
    const sandwichPrice = checkedItems.sandwich ? sandwichPrices[selectedSandwich] : 0;
    const drinkPrice = checkedItems.drink ? parseInt(selectedDrink) : 0;
    const optionPrice = checkedItems.option ? parseInt(selectedOption) : 0;

    setTotalPrice((sandwichPrice + drinkPrice + optionPrice) * quantity);
  }, [checkedItems, selectedSandwich, selectedDrink, selectedOption, quantity]);

  const handleCheckChange = (e) => {
    const { name, checked } = e.target;
    setCheckedItems((prev) => ({ ...prev, [name]: checked }));
  };

  const onSubmit = (data) => {
    const finalData = {
...data,      
      sandwich: checkedItems.sandwich ? selectedSandwich : null,
      drink: checkedItems.drink ? selectedDrink : null,
      option: checkedItems.option ? selectedOption : null,
      totalPrice,

      

    };

    addOrder(finalData)

    alert('신청접수가 완료되었습니다.');
    console.log('전송 데이터:', finalData);
    navigate('/');
  };


  return (
    <form onSubmit={handleSubmit(onSubmit)}>
      <h1>단체주문 신청서</h1>
      <p>단체주문 예약은 최소 3일 전 신청해주세요.</p>

      <CardContainer>
        <TableTitle>기본정보</TableTitle>
        <FormTable>
          <tbody>
            <tr>
              <th>이름</th>

              <td>
                <input type='hidden'{...register('user')} value={currentUser.id}></input>
                <input type="text" {...register('name')} />
                {errors.name && <p>{errors.name.message}</p>}
              </td>
            </tr>
            <tr>
              <th>연락처</th>
              <td>
                {' '}
                <input type="text" placeholder="숫자만입력해주세요" {...register('phone')} />
                {errors.phone && <p>{errors.phone.message}</p>}
              </td>
            </tr>
            <tr>
              <th>이메일</th>
              <td>
                {' '}
                <input type="email" {...register('email')} />
                {errors.email && <p>{errors.email.message}</p>}
              </td>
            </tr>
          </tbody>
        </FormTable>
      </CardContainer>

      <CardContainer>
        <TableTitle>주문정보</TableTitle>
        <OrderTable>
          <tbody>
            <tr>
              <th rowSpan={3}>메뉴선택</th>
              <td>
                <input type="checkbox" {...register('sandwich')} 
                checked={checkedItems.sandwich} onChange={ (e) => {handleCheckChange(e); setValue('sandwich',e.target.checked)}} />
                샌드위치
              </td>
              <td>
                {checkedItems.sandwich && (
                  <>
                    <select
                      value={selectedSandwich}
                      onChange={(e) => {
                        setSelectedSandwich(e.target.value);
                        setValue('selectedSandwich', e.target.value);
                      }}
                    >
                      {Object.entries(sandwichPrices).map(([name, price]) => (
                        <option key={name} value={name}>
                          {name} ({price.toLocaleString()}원)
                        </option>
                      ))}
                    </select>
                  </>
                )}
              </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" {...register('drink')} onChange={handleCheckChange} />
                음료
              </td>

              <td>
                {checkedItems.drink && (
                  <select
                    value={selectedDrink}
                    onChange={(e) => 
                      setSelectedDrink(e.target.value)
                      }
                  >
                    <option value="1000">팩음료 (1,000원)</option>
                    <option value="1500">병음료 (1,500원)</option>
                  </select>
                )}
              </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" {...register('option')} onChange={handleCheckChange} />
                추가옵션
              </td>

              <td>
                {checkedItems.option && (
                  <select
                    value={selectedOption}
                    onChange={(e) => 
                      setSelectedOption(e.target.value)
                     
                    }
                  >
                    <option value="1500">쿠키 (1,500원)</option>
                    <option value="2000">치킨너겟 (2,000원)</option>
                    <option value="3000">과일 (3,000원)</option>
                  </select>
                )}
              </td>
            </tr>
            <tr>
              <th>총개수 </th>
              <td colSpan={2}>
                <input
                  type="number"
                  {...register('quantity')}
                  value={quantity}
                  min={1}
                  onChange={(e) => {
                    const val = parseInt(e.target.value) || 1;
                    setQuantity(val);
                    setValue('quantity', val); // 폼에도 동기화
                  }}
                />
                {errors.quantity && <p>{errors.quantity.message}</p>}
              </td>
            </tr>
            <tr>
              <TableTd colSpan={3}>
                <p>총 가격: {totalPrice.toLocaleString()}원</p>
              </TableTd>
            </tr>
          </tbody>
        </OrderTable>
      </CardContainer>

      <CardContainer>
        <TableTitle>배송정보</TableTitle>
        <FormTable>
          <tbody>
            <tr>
              <th>배송 희망일</th>
              <td>
                <input type="date" {...register('date')} />
              </td>
            </tr>
            <tr>
              <th>배송 주소</th>
              <td>
                {' '}
                <input type="text" placeholder="상세주소" {...register('address')} />
              </td>
            </tr>
          </tbody>
        </FormTable>
      </CardContainer>

      <button type="submit">신청하기</button>
    </form>
  );
};

export default MenuOrder;