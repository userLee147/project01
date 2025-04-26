import React, { useContext } from 'react';
import { useLocation, useNavigate, useParams } from 'react-router-dom';
import { useUser } from '../components/context/UserContext';
import styled from 'styled-components';

const Wrap = styled.div`
  width: 300px;
  border: 1px solid #c5c5c5;
`;



const Title = styled.h3`
  height: 50px;
  padding: 12px;
  align-items: center;
  font-size: 16px;
  font-weight: bold;
  background-color: white;
`;

const ItemBox = styled.div`
  
  display: flex;
  flex-direction: column;
  justify-content: center;
   align-items: center;
       border-bottom:1px solid #c5c5c5 ;
  border-top:1px solid #c5c5c5 ;
`;


const Img =styled.img`
 width: 150px;
 height: 150px;
 margin: 10px;
`
const ItemTable = styled.table`
  margin: 0 auto; /* 수평 가운데 정렬 */
  border-collapse: collapse;
  text-align: center;
  
`

const ItemDiv = styled.div`
  justify-content: center;
align-items: center;
text-align: cneter;
   background-color: white;
`
const ItemTr =styled.tr`

`
const ItemTd =styled.td`
 width: 50px;
 padding: 10px;
`
const ItemTH =styled.th`
 width: 50px;


`
const ItemDiv2 = styled.div`
 width: 100%;

     border-top:1px solid #c5c5c5 ;
`
const Btn = styled.button`
background-color: #e7e7ee;
border: 1px solid #c5c5c5;
width: 40%;
height: 40px;
margin: 10px;
font-size: 15px;
 border-radius: 4px;
 background-color: white;
`;




const UserDetail = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { getUserById, deleteUser } = useUser();
  const user = getUserById(parseInt(id));

  const handleDelete = () => {
    if (window.confirm('정말로 이 사용자를 삭제하시겠습니까?')) {
      deleteUser(parseInt(id));
      navigate('/');
    }
  };

  return (
    <Wrap>

      <Title>유저상세페이지</Title>

      <ItemBox>
        <Img src={user.img} />
        <p>{user.login ? '🟢 온라인' : '🔴 오프라인'}</p>
      </ItemBox>
      <ItemDiv>
        <ItemTable>
        <ItemTr>
            <ItemTH>이 름</ItemTH>
            <ItemTd>{user.name}</ItemTd>
        </ItemTr>
        <ItemTr>
            <ItemTH>나 이</ItemTH>
            <ItemTd>{user.age}</ItemTd>
        </ItemTr>
        <ItemTr>
            <ItemTH>부 서</ItemTH>
            <ItemTd>{user.department}</ItemTd>
        </ItemTr>
        </ItemTable>
      </ItemDiv>
      <ItemDiv2>
      <Btn onClick={() => navigate('/')}>뒤로가기</Btn>
      <Btn onClick={handleDelete}>삭제하기</Btn>
      </ItemDiv2>

    </Wrap>
  );
};

export default UserDetail;
