import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useUser } from '../components/context/UserContext';
import styled from 'styled-components';

const Wrap = styled.div`
  width: 300px;
  border: 1px solid #c5c5c5;

`;
const FormItem = styled.form`
    border-bottom:1px solid #c5c5c5 ;
  border-top:1px solid #c5c5c5 ;
  background-color: white;
  display: flex;
  flex-direction: column;
`;
const Title = styled.h3`
  height: 50px;
  padding: 12px;
  align-items: center;
  font-size: 16px;
  font-weight: bold;
  background-color: #e7e7ee;
`;

const ItemInput = styled.input`
  padding: 10px;
  width: 80%;
  margin: 10px 0px;
  border: 1px solid #c5c5c5;
`;

const SelectBox = styled.select`
  padding: 10px;
  width: 80%;
  margin: 10px 0px;
  border: 1px solid #c5c5c5;
`;

const FormBtn = styled.button`
background-color: #e7e7ee;
border: 1px solid #c5c5c5;
width: 40%;
height: 40px;
margin: 10px;
font-size: 15px;
 border-radius: 4px;
`;
const ContentBtn = styled.button`
background-color: white;
border: 1px solid #c5c5c5;
border-radius: 4px;
width: 90%;
height: 50px;
margin: 10px;
`;
const UserRegistration = () => {
  const { users, setUsers } = useUser();
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    name: '',
    age: '',
    department: '',
    isOnline: false,
  });

  const handleSubmit = (e) => {
    e.preventDefault();
    const newId = users.length + 1;

    setUsers([
      ...users,
      {
        id: newId,
        name: formData.name.trim(),
        department: formData.department,
        age: parseInt(formData.age),
        isOnline: formData.isOnline,
      },
    ]);
    navigate('/');
  };

  const changeValue = (e) => {
    const { name, value, type } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };



  return (
    <Wrap>
      <Title>유저 등록페이지</Title>
      <FormItem onSubmit={handleSubmit}>
        <label htmlFor="name">
          이름 &nbsp;
          <ItemInput
            name="name"
            id="name"
            type="text"
            placeholder="이름를 입력해주세요"
            value={formData.name}
            onChange={changeValue}
            required
          />
        </label>

        <label htmlFor="age">
          나이 &nbsp;
          <ItemInput
            name="age"
            id="age"
            type="number"
            placeholder="나이를 입력해주세요"
            value={formData.age}
            onChange={changeValue}
            required
          />
        </label>

        <label htmlFor="department">
          부서 &nbsp;
          <SelectBox
            name="department"
            id="department"
            value={formData.department}
            onChange={changeValue}
          >
            부서
            <option value="행정">행정</option>
            <option value="영업">영업</option>
            <option value="회계">회계</option>
            <option value="전산">전산</option>
          </SelectBox>
        </label>

        <div>
          <FormBtn type="submit">등록하기</FormBtn>
          <FormBtn type="ret" onClick={() => navigate('/')}>
            취소
          </FormBtn>
        </div>
      </FormItem>
      <ContentBtn onClick={() => navigate('/')}>홈으로 가기</ContentBtn>
    </Wrap>
  );
};

export default UserRegistration;
