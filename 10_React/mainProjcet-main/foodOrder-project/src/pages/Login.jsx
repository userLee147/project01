import React, {useState } from 'react';
import useUserStore from '../store/UserStore';
import { CommonBtn, Wrap,HeaderWrap } from '../styled/common';

import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import Header from '../components/Header';

const Login = () => {
  const [id, setId] = useState('');
  const [pwd, setPwd] = useState('');
  const { currentUser, login, logout } = useUserStore();
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();

    if( id.trim() === '' || pwd.trim() === ''){
      return
    }

    try{
        await login(id, pwd);
        navigate('/')
    }catch (err){
        alert(err.message)
    }

  };

  const handleLogout = async (e) => {
    e.preventDefault();
    await logout(currentUser);
    navigate('/')
  };
  

  // useEffect(() => {
  //   console.log("유저 상태 변화:", currentUser);
  // }, [currentUser]);

  return (
    <Wrap>
 <Header></Header>
      <FormWrapper onSubmit={handleLogin}>
        <h1>로그인 화면</h1>
        <label htmlFor="id">아이디</label>
        <input type="text" id="id" value={id} onChange={(e) => setId(e.target.value)} />

        <label htmlFor="pwd">패스워드</label>
        <input type="password" id="pwd" value={pwd} onChange={(e) => setPwd(e.target.value)} />

        <button type="submit">로그인</button>
      </FormWrapper>

      <div>
      <CommonBtn to="/user">회원가입</CommonBtn>
      <CommonBtn to="/">홈으로</CommonBtn>
      </div>

    </Wrap>
  );
};

export default Login;



const FormWrapper = styled.form`
  display: flex;
  flex-direction: column;
  gap: 12px;
  padding: 18px;
  max-width: 600px;
  margin: 0 auto;

  input {
    padding: 8px;
    border: 1px solid #cccccc;
    border-radius: 4px;
  }

  button {
    padding: 10px;
    background:  #ff5100;
    color: white;
    border: none;
    border-radius: 6px;
    cursor: pointer;
  }
`;

